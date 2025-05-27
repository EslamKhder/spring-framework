import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
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
}
