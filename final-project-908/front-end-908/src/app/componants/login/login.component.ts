import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messageAr: string = "";
  messageEn: string = "";
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }


  login(userName, password){

    if (!this.validateInputs(userName, password)) {
      setTimeout(() => {
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    // CALL API

    this.authService.login(userName, password).subscribe(
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


  validateInputs(userName, password){
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

    return true;
  }


}
