import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../service/security/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private route: Router, private authService: AuthService) {
  }

  search(key){
    this.route.navigateByUrl("/search/" + key)
  }

  isUserLogin(): boolean{
    return this.authService.isUserLogin();
  }

  logout() {
    this.authService.logout();
    this.route.navigateByUrl("/login")
  }
}
