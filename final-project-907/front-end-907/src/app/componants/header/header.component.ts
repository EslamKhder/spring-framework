import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../service/security/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router: Router, private authService: AuthService) {
  }
  search(value: string) {
    this.router.navigateByUrl("/search/" + value)
  }

  isUserLogin(): boolean{
    return this.authService.isUserLogin();
  }

  isUserAdmin(): boolean{
    return this.authService.isUserAdmin();
  }

  logout() {
    this.router.navigateByUrl("/login")
    this.authService.logout();
  }
}
