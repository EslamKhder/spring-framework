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

  login(userName, password) {
    // validate input

    if (!this.validate(userName, password)) {
      setTimeout(() => {
        this.messageAr = "";
        this.messageEn = "";
      }, 3000);
      return;
    }

    // call api to create account

    this.authService.login(userName, password).subscribe(
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
  validate(userName, password): boolean {

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

    return true;
  }

}
