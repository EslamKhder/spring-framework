import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";
import {Router} from "@angular/router";
import {AuthService} from "../../../service/auth/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  category: Category[] = [];
  constructor(private categoryService: CategoryService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.loadAllCategory()
  }

  loadAllCategory(){
    this.categoryService.getAllCategory().subscribe(
      response => {
        this.category = response
      }
    )
  }


  search(keySearch){
    this.router.navigateByUrl("/search/" + keySearch) // rice
  }

  logOut() {
    sessionStorage.removeItem('token');
    this.router.navigateByUrl("/login") // rice
  }

  isUserLogin(){
    return this.authService.isUserLogIn();
  }

  login() {
    this.router.navigateByUrl("/login")
  }

  signup() {
    this.router.navigateByUrl("/signup")
  }
}
