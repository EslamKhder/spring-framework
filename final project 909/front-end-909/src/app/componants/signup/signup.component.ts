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

  createAccount(userName: string, password: string, confirmPassword: string) {

    if (!this.validateInput(userName, password, confirmPassword)) {
      return;
    }

    this.authService.signup(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        sessionStorage.setItem("roles", response.userRoles);
        this.router.navigateByUrl("/product");
      }, error => {
        this.messageEn = error.error.bundleMessage.message_ar;
        this.messageAr = error.error.bundleMessage.message_en;
      }
    );
  }

  validateInput(userName: string, password: string, confirmPassword: string): boolean {

    if (!userName) {
        this.messageEn = "Username is required.";
        this.messageAr = "اسم المستخدم مطلوب.";
        return false;
    }

    if (!password) {
      this.messageEn = "Password is required.";
      this.messageAr = "كلمة المرور مطلوبة.";
      return false;
    }

    if (!confirmPassword) {
      this.messageEn = "Confirm Password is required.";
      this.messageAr = "تأكيد كلمة المرور مطلوب.";
      return false;
    }

    if (password !== confirmPassword) {
      this.messageEn = "Password and Confirm Password do not match.";
      this.messageAr = "كلمة المرور وتأكيد كلمة المرور غير متطابقين.";
      return false;
    }

    this.messageEn = "";
    this.messageAr = "";

    return true;
  }

  isMessageEnValid(): boolean{
    return this.messageEn !== null && this.messageEn !== undefined && this.messageEn !== "";
  }

  isMessageArValid(): boolean{
    return this.messageAr !== null && this.messageAr !== undefined && this.messageAr !== "";
  }
}
