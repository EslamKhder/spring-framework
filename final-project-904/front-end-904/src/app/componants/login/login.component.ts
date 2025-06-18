import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../services/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService :AuthService, private router: Router) { }

  isUserNameValid: boolean = false;
  isPasswordValid: boolean = false;
  messageAr: string = '';
  messageEn: string = '';

  ngOnInit(): void {
  }


  logIn(userName, password){
    if (!this.validateInputs(userName, password)) {
      return;
    }

    this.authService.login(userName, password).subscribe(
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

  private validateInputs(userName: string, password: string) {
    if (!userName) {
      this.isUserNameValid = true;
      return false;
    }

    if (!password) {
      this.isPasswordValid = true;
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
}
