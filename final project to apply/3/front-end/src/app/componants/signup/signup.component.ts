import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  messageResultEn: string = "";
  messageResultAr: string = "";

  constructor(private authService: AuthService,
              private route: Router) { }

  ngOnInit(): void {
  }

  signup(email, password, confirmPassword) {
    if (email === '') {
      this.messageResultAr = "يجب ادخال الايميل"
      this.messageResultEn = "please enter your email"
      setTimeout(() => {
        this.messageResultEn = '';
        this.messageResultAr = '';
      }, 3000);
      return;
    }

    if (password === '' || confirmPassword === '') {
      this.messageResultAr = "يجب ادخال الرقم السري";
      this.messageResultEn = "please enter your password";
      setTimeout(() => {
        this.messageResultEn = '';
        this.messageResultAr = '';
      }, 3000);
      return;
    }

    if (password !== confirmPassword) {
      this.messageResultAr = "الرقم السري غير متطابق";
      this.messageResultEn = "password not matched";
      setTimeout(() => {
        this.messageResultEn = '';
        this.messageResultAr = '';
      }, 3000);
      return;
    }

    this.authService.createClient(email, password).subscribe(
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

          // alert(this.messageResultEn)
          // alert(this.messageResultAr)
        } else {
          this.route.navigateByUrl("/login");
        }
      }
    )
  }
}
