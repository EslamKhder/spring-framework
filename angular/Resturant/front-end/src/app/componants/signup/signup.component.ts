import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/security/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private authService: AuthService,
              private route: Router) { }

  ngOnInit(): void {
  }

  signup(email, password, confirmPassword) {
    if (password !== confirmPassword) {
      alert("Invalid Password");
      return;
    }
    this.authService.createClient(email, password).subscribe(
      data => {
        alert("client created");
        this.route.navigateByUrl("/login");
      }
    )
  }
}
