import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messageResultEn: string = "";
  messageResultAr: string = "";

  constructor(private authService: AuthService,
              private route: Router) { }

  ngOnInit(): void {
  }

  login(email, password) {
    if (email === '') {
      this.messageResultAr = "يجب ادخال الايميل"
      this.messageResultEn = "please enter your email"
      setTimeout(() => {
        this.messageResultEn = '';
        this.messageResultAr = '';
      }, 3000);
      return;
    }

    if (password === '') {
      this.messageResultAr = "يجب ادخال الرقم السري";
      this.messageResultEn = "please enter your password";
      setTimeout(() => {
        this.messageResultEn = '';
        this.messageResultAr = '';
      }, 3000);
      return;
    }

    this.authService.loginClient(email, password).subscribe(
      data => {
        if (data && 'status' in data && data.status === 'BAD_REQUEST') {

          // @ts-ignore
          this.messageResultEn = data.bundleMessage.message_en;

          // @ts-ignore
          this.messageResultAr = data.bundleMessage.message_ar;

          setTimeout(() => {
            this.messageResultEn = '';
            this.messageResultAr = '';
          }, 3000);

        } else {
          sessionStorage.setItem("token", "Bearer " + data.token)
          this.route.navigateByUrl("/products");
        }
      }
    )
  }

}
