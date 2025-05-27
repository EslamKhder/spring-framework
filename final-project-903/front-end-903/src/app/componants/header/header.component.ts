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
    let idCategoryExist = this.activatedRoute.snapshot.paramMap.has("id");
    if (idCategoryExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get("id");
      this.router.navigateByUrl("/category/" + idCategory + "/search/" + key);
      return
    }
    this.router.navigateByUrl("/search/" + key)
  }
}
