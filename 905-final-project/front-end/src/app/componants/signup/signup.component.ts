import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  messageAr: string = '';
  messageEn: string = '';
  constructor(private authService: AuthService, private routes: Router) { }

  ngOnInit(): void {
  }

  createAccount(username, password, confirmPassword) {
    if(!this.validateAccount(username, password, confirmPassword)){
      setTimeout(() => {
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    this.authService.createAccount(username, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        this.routes.navigateByUrl("/products");
      } , error => {
        this.messageAr = error.error.bundleMessage.message_ar;
        this.messageEn = error.error.bundleMessage.message_en;
        setTimeout(() => {
          this.messageAr = "";
          this.messageEn = "";
        }, 3000);
      }
    )
  }

  validateAccount(username: string, password: string, confirmPassword: string): boolean {
    if (!username) {
      this.messageAr = "اسم المستخدم مطلوب";
      this.messageEn = "Username is required";
      return false;
    }

    if (!password) {
      this.messageAr = "كلمة المرور مطلوبة";
      this.messageEn = "Password is required";
      return false;
    }

    if (!confirmPassword) {
      this.messageAr = "تأكيد كلمة المرور مطلوب";
      this.messageEn = "Confirm password is required";
      return false;
    }

    if (password !== confirmPassword) {
      this.messageAr = "كلمة المرور وتأكيد كلمة المرور غير متطابقين";
      this.messageEn = "Password and confirm password do not match";
      return false;
    }

    return true;
  }

}
