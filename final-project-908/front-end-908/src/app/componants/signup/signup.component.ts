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


  createAccount(userName, password, confirmPassword){

    if (!this.validateInputs(userName, password, confirmPassword)) {
      setTimeout(() => {
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    // CALL API

    this.authService.signUp(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        sessionStorage.setItem("userRoles", response.userRoles);
        this.router.navigateByUrl("/product");
      } , errorResponse => {
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    );

    setTimeout(() => {
      this.messageAr = "";
      this.messageEn = "";
    }, 3000);

  }


  validateInputs(userName, password, confirmPassword){
    if (!userName){
      this.messageAr = "من فضلك أدخل اسم المستخدم";
      this.messageEn = "Please enter a username";
      return false;
    }

    if (!password){
      this.messageAr = "من فضلك أدخل كلمة المرور";
      this.messageEn = "Please enter a password";
      return false;
    }

    if (!confirmPassword){
      this.messageAr = "من فضلك أدخل تأكيد كلمة المرور";
      this.messageEn = "Please enter the confirm password";
      return false;
    }

    if (password !== confirmPassword){
      this.messageAr = "كلمة المرور وتأكيدها غير متطابقين";
      this.messageEn = "Password and confirm password do not match";
      return false;
    }

    return true;
  }

}
