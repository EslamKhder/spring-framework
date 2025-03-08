import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  messageAr: String = '';
  messageEn: String = '';

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
  }


  createAccount(name, phone, email, password, confirmPassword) {

    if (name === '') {
      this.messageAr = "يجب ادخال الاسم"
      this.messageEn = "please enter your name"

      this.extracted();
      return;
    }

    if (phone === '') {
      this.messageAr = "يجب ادخال رقم الهاتف"
      this.messageEn = "please enter your phone"
      this.extracted();
      return;
    }

    if (email === '') {
      this.messageAr = "يجب ادخال الايميل"
      this.messageEn = "please enter your email"
      this.extracted();
      return;
    }

    if (password === '' || confirmPassword === '') {
      this.messageAr = "يجب ادخال الرقم السري";
      this.messageEn = "please enter your password";
      this.extracted();
      return;
    }


    if (confirmPassword !== password) {
      this.messageAr = "الرقم السري غير متطابق";
      this.messageEn = "password not matched";
      this.extracted();
      return;
    }


    this.authService.createAccount(name, phone, email, password).subscribe(
      (response) => {
        if (response && 'status' in response && response.status === 'NOT_ACCEPTABLE') {
          // @ts-ignore
          this.messageAr = response.bundleMessage.message_ar;
          // @ts-ignore
          this.messageEn = response.bundleMessage.message_en;

          this.extracted();
        } else {
          this.router.navigateByUrl("/login");
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

/*


// @ts-ignore
                if (response && 'status' in response && response.status === 'NOT_ACCEPTABLE')
                  // @ts-ignore
                  this.messageAr = response.bundleMessage.message_ar;
                // @ts-ignore
                this.messageEn = response.bundleMessage.message_en;
              } else {

               }*
 */
