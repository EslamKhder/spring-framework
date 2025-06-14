import { Component } from '@angular/core';
import {UserService} from "../service/security/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private userService: UserService) {
  }


  isUserLogin(){
    return this.userService.isUserLogin();
  }


}
