import { Component } from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  products: Product[] = [];

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () =>  this.handelAllAction()
    )

  }

  constructor(private productService :ProductService, private activatedRoute: ActivatedRoute) {
  }

  handelAllAction(){
    let idCategoryExist = this.activatedRoute.snapshot.paramMap.has("id");
    let idKeyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (idCategoryExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get("id");
      this.getProductByCategoryId(idCategory)
    } else if (idKeyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.getProductByKey(key)
    } else {
      this.getAllProducts()
    }
  }

  getAllProducts(){
    this.productService.getAllProducts().subscribe(
      response => {
        this.products = response
      }
    )
  }

  getProductByCategoryId(id){
    this.productService.getProductsByCategoryId(id).subscribe(
      response => {
        this.products = response
      }
    )
  }

  getProductByKey(key){
    this.productService.getProductsByKey(key).subscribe(
      response => {
        this.products = response
      }
    )
  }
}
