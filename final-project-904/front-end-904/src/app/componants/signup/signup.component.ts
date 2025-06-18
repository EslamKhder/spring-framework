import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../services/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private authService :AuthService, private router: Router) { }

  isUserNameValid: boolean = false;
  isPasswordValid: boolean = false;
  isConfirmPasswordValid: boolean = false;
  isPasswordMatched: boolean = false;
  messageAr: string = '';
  messageEn: string = '';
  ngOnInit(): void {
  }

  createAccount(userName: string, password: string, confirmPassword: string) {
    if (!this.validateInputs(userName, password, confirmPassword)) {
      return;
    }

    this.authService.createAccount(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token)
        sessionStorage.setItem("userName", response.username)
        sessionStorage.setItem("roles", response.roles)
        this.router.navigateByUrl("/products")
      }, errorResponse => {
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    )
  }

  private validateInputs(userName: string, password: string, confirmPassword: string) {
    if (!userName) {
      this.isUserNameValid = true;
      return false;
    }

    if (!password) {
      this.isPasswordValid = true;
      return false;
    }

    if (!confirmPassword) {
      this.isConfirmPasswordValid = true;
      return false;
    }

    if (password !== confirmPassword) {
      this.isPasswordMatched = true;
      return false;
    }

    return true;
  }

  clearUserName() {
    this.isUserNameValid = false;
    this.messageAr= '';
    this.messageEn= '';
  }

  clearPassword() {
    this.isPasswordValid = false;
    this.messageAr= '';
    this.messageEn= '';
  }

  clearConfirmPassword() {
    this.isConfirmPasswordValid = false;
    this.isPasswordMatched = false;
    this.messageAr= '';
    this.messageEn= '';
  }
}
