import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messageAr: String = '';
  messageEn: String = '';

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
  }


  login(email, password) {
    if (email === '') {
      this.messageAr = "يجب ادخال الايميل"
      this.messageEn = "please enter your email"
      this.extracted();
      return;
    }

    if (password === '') {
      this.messageAr = "يجب ادخال الرقم السري";
      this.messageEn = "please enter your password";
      this.extracted();
      return;
    }


    this.authService.login(email, password).subscribe(
      (response) => {
        if (response && 'status' in response && response.status === 'NOT_ACCEPTABLE') {
          // @ts-ignore
          this.messageAr = response.bundleMessage.message_ar;
          // @ts-ignore
          this.messageEn = response.bundleMessage.message_en;

          this.extracted();
        } else {
          sessionStorage.setItem('token', 'Bearer ' + response.token)
          this.router.navigateByUrl("/products");
        }
      }
    );
  }

  private extracted() {
    setTimeout(() => {
      this.messageAr = '';
      this.messageEn = '';
    }, 3000);
  }

}
