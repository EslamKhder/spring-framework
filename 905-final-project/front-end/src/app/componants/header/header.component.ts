import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../service/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {


  constructor(private routes: Router, private authService: AuthService) {
  }



  isUserLogin(): boolean {
    return this.authService.isUserLogin();
  }
  isAdmin(): boolean {
    return this.authService.isAdmin();
  }

  search(key){
    this.routes.navigateByUrl("/products/" + key);
  }

  logOut(){
    this.authService.logOut();
    this.routes.navigateByUrl("/login");
  }
}
