import { Component } from '@angular/core';
import {AuthService} from "../services/security/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private authService: AuthService) {
  }

  isUserLogin() {
    return this.authService.isUserLogin();
  }
}
