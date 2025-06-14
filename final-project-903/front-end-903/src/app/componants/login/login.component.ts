import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../service/security/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messageAr: string = "";
  messageEn: string = "";
  isUserNameValid: boolean = false;
  isPasswordValid: boolean = false;
  constructor(private userService :UserService, private router: Router) { }

  ngOnInit(): void {
  }

  login(userName, password){
    if (!this.validation(userName, password)) {
      return;
    }
    this.userService.login(userName, password).subscribe(
      response => {
        sessionStorage.setItem("roles", response.roles);
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

  validation(userName, password): boolean {
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
    return true;
  }

  clear() {
    this.messageAr = '';
    this.messageEn = '';
  }

}
