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

  login(userName: string, password: string) {

    if (!this.validateInput(userName, password)) {
      return;
    }

    this.authService.login(userName, password).subscribe(
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

  validateInput(userName: string, password: string): boolean {

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
