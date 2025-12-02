import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  messageAr: string;
  messageEn: string;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  createAccount(userName, password, confirmPassword) {
    if (!this.validateInputs(userName, password, confirmPassword)) {
      setTimeout(() => {
        // your code here
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    // call api signup
    this.authService.signup(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        sessionStorage.setItem("username", response.username);
        sessionStorage.setItem("userRoles", response.userRoles);
        this.router.navigateByUrl("/products");
      }, errorResponse => {
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        setTimeout(() => {
          // your code here
          this.messageAr = "";
          this.messageEn = "";
        }, 3000);
      }
    )
  }


  validateInputs(userName, password, confirmPassword): boolean {
    if (!userName) {
      this.messageAr = "من فضلك أدخل اسم المستخدم";
      this.messageEn = "Please enter a username";
      return false;
    }

    if (!password) {
      this.messageAr = "من فضلك أدخل كلمة المرور";
      this.messageEn = "Please enter a password";
      return false;
    }

    if (!confirmPassword) {
      this.messageAr = "من فضلك أكد كلمة المرور";
      this.messageEn = "Please confirm your password";
      return false;
    }

    if (password !== confirmPassword) {
      this.messageAr = "كلمة المرور غير متطابقة";
      this.messageEn = "Passwords do not match";
      return false;
    }


    return true;
  }


}
