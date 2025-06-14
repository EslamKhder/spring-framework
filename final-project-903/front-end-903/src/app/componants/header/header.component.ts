import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../../service/security/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router: Router, private activatedRoute: ActivatedRoute,private userService: UserService) {
  }
  search(key) {
    const idCategoryExist = this.activatedRoute.firstChild.snapshot.paramMap.has("id");

    if (idCategoryExist) {
      const idCategory = this.activatedRoute.firstChild.snapshot.paramMap.get("id");
      this.router.navigateByUrl(`/category/${idCategory}/search/${key}`);
    } else {
      this.router.navigateByUrl(`/search/${key}`);
    }
  }

  isUserLogin(){
    return this.userService.isUserLogin();
  }

  isUserAdmin(){
    return this.userService.isUserAdmin();
  }


  logout(){
    this.userService.logout();
    this.router.navigateByUrl(`/login`);
  }
}
