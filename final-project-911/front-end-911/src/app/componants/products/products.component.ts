import {Component, OnInit} from '@angular/core';
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
export class ProductsComponent  implements OnInit{

  products: Product[] = [];

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.getProductsBasedOnAction()
    );
  }

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) {
  }

  getProductsBasedOnAction() {
    debugger
    let isIdExist = this.activatedRoute.snapshot.paramMap.has('id');
    let isKeyExist = this.activatedRoute.snapshot.paramMap.has('key');

    if (isIdExist) {
      let id = this.activatedRoute.snapshot.paramMap.get('id');
      this.getProductsByCategoryId(id);
    } else if (isKeyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get('key');
      this.search(key);
    } else {
      this.getProducts();
    }

  }

  getProducts(): void {
    this.productService.getAllProducts().subscribe(
      response => this.products = response
    );
  }
  getProductsByCategoryId(id): void {
    this.productService.getProductsByCategoryId(id).subscribe(
      response => this.products = response
    );
  }
  search(key): void {
    this.productService.search(key).subscribe(
      response => this.products = response
    );
  }



}

