import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  messageAr: string = "";
  messageEn: string = "";

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  createAccount(userName, password, confirmPassword) {
    // validate input

    if (!this.validate(userName, password, confirmPassword)) {
      setTimeout(() => {
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    // call api to create account

    this.authService.signup(userName, password).subscribe(
      response => {
        this.router.navigateByUrl("/products");
      }, failed => {
        debugger
        this.messageAr = failed.error.bundleMessage.message_ar;
        this.messageEn = failed.error.bundleMessage.message_en;
      }
    )
  }

  // a = 1     "5"==5    "5"===5
  // "              "  --> ""
  validate(userName, password, confirmPassword): boolean {

    if (!userName) {
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
      this.messageEn = "Confirm Password is required";
      return false;
    }

    if (password !== confirmPassword) {
      this.messageAr = "كلمة المرور وتأكيد كلمة المرور غير متطابقين";
      this.messageEn = "Password and Confirm Password do not match";
      return false;
    }

    return true;
  }
}
