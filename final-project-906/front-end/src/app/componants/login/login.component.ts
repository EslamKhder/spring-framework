import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messageAr: String = "";
  messageEn: String = "";
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

    // Call API

    this.authService.login(userName, password).subscribe(
      response => {
        sessionStorage.setItem("token", response.token);
        sessionStorage.setItem("roles", response.userRoles);
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

  validateInputs(userName: string, password: string): boolean {
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

    return true;
  }

}
