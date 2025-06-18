import { Component } from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../services/security/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private router: Router, private authService: AuthService) {
  }


  public searchProduct(key){
    this.router.navigateByUrl("search/" + key)
  }

  getUserName(){
    return sessionStorage.getItem("userName")
  }

  isUserLogin(){
    return this.authService.isUserLogin();
  }

  idUserAdmin(){
    return this.authService.isUserAdmin();
  }

  logOut() {
    this.authService.logOut();
    this.router.navigateByUrl('login');
  }
}
