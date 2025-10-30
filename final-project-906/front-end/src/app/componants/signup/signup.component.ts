import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  messageAr: String = "";
  messageEn: String = "";
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  createAccount(userName, password, confirmPassword){
    if (!this.validateInputs(userName, password, confirmPassword)) {
      setTimeout(() => {
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    // Call API

    this.authService.signup(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        this.router.navigateByUrl("/products");
      }, error => {
        this.messageAr = error.error.bundleMessage.message_ar;
        this.messageEn = error.error.bundleMessage.message_en;
        setTimeout(() => {
          this.messageAr = "";
          this.messageEn = "";
        }, 3000);
      }
    )
  }

  validateInputs(userName: string, password: string, confirmPassword: string): boolean {
    if (!userName) {
      this.messageAr = "اسم المستخدم اجباري";
      this.messageEn = "Username is required";
      return false;
    }

    if (!password) {
      this.messageAr = "كلمة المرور اجبارية";
      this.messageEn = "Password is required";
      return false;
    }

    if (!confirmPassword) {
      this.messageAr = "تأكيد كلمة المرور اجباري";
      this.messageEn = "Confirm password is required";
      return false;
    }

    if (password !== confirmPassword) {
      this.messageAr = "كلمة المرور وتأكيدها غير متطابقين";
      this.messageEn = "Password and confirm password do not match";
      return false;
    }

    return true;
  }


}
