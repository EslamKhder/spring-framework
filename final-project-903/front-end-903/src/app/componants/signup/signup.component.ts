import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../service/security/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  messageAr: string = "";
  messageEn: string = "";
  isUserNameValid: boolean = false;
  isPasswordValid: boolean = false;
  isConfirmPasswordValid: boolean = false;
  isPasswordMatch: boolean = false;
  constructor(private userService :UserService, private router: Router) { }

  ngOnInit(): void {
  }

  createAccount(userName, password, confirmPassword){
    if (!this.validation(userName, password, confirmPassword)) {
      return;
    }
    debugger
    this.userService.createAccount(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        sessionStorage.setItem("userName", response.username);
        this.router.navigateByUrl("products");
      }, errors => {
        // @ts-ignore
        this.messageAr = errors.error.bundleMessage.message_ar;
        // @ts-ignore
        this.messageEn = errors.error.bundleMessage.message_en;
      }
    )
  }

  validation(userName, password, confirmPassword): boolean {
    if (!userName) {
      this.isUserNameValid = true;
      setTimeout(() => {
        this.isUserNameValid = false;
      }, 3000);
      return false;
    }
    if (!password) {
      this.isPasswordValid = true;
      setTimeout(() => {
        this.isPasswordValid = false;
      }, 3000);
      return false;
    }
    if (!confirmPassword) {
      this.isConfirmPasswordValid = true;
      setTimeout(() => {
        this.isConfirmPasswordValid = false;
      }, 3000);
      return false;
    }

    if (password !== confirmPassword) {
      this.isPasswordMatch = true;
      setTimeout(() => {
        this.isPasswordMatch = false;
      }, 3000);
      return false;
    }

    return true;
  }

  clear() {
    this.messageAr = '';
    this.messageEn = '';
  }
}
