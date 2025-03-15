import { Component } from '@angular/core';
import {CategoryService} from "../service/category.service";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private authService: AuthService) { }

  isUserLogin(){
    return this.authService.isUserLogIn();
  }

}
