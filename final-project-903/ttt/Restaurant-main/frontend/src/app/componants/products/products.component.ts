import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/product";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[] = [];

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      ()=> this.handelAllActions()
    )
  }

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) { }

  handelAllActions(): void {
    // debugger
    let isIdCategoryExist = this.activatedRoute.snapshot.paramMap.has("id");
    let isKeyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (isIdCategoryExist) {
      let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
      this.getProductsByCategoryId(categoryId);
    } else if (isKeyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.searchByNameOrDescription(key);
    }else {
      this.getAllProducts()
    }
  }

  getAllProducts() {
    this.productService.getAllProducts().subscribe(
      response => {
        this.products = response;
      }
    )
  }

  getProductsByCategoryId(id) {
    this.productService.getProductsByCategoryId(id).subscribe(
      response => {
        this.products = response;
      }
    )
  }

  searchByNameOrDescription(key){
    this.productService.searchByNameOrDescription(key).subscribe(
      response => {
        this.products = response;
      }
    )
  }

}
