import { Component } from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private router: Router) {
  }


  public searchProduct(key){
    this.router.navigateByUrl("search/" + key)
  }
}
