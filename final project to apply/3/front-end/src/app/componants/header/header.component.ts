import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/security/auth.service";
import {Category} from "../../model/category";
import {CategoryServiceService} from "../../service/category-service.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  categories: Category[] = [];
  constructor(private route: Router, private authService: AuthService, private categoryService: CategoryServiceService) {
  }


  ngOnInit(): void {
    this.getAllCategories()
  }

  getAllCategories(){
    this.categoryService.getAllCategories().subscribe(
      data => {
        this.categories = data;
      }
    )
  }

  search(word){
    this.route.navigateByUrl("/products/" + word);
  }


  isUserLogin(){
    return this.authService.isUserLogin();
  }

  logOut() {
    this.authService.logOutClient()
    this.route.navigateByUrl("/login");
  }
}
