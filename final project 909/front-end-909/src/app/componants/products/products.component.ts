import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Category} from "../../../model/category";
import {Product} from "../../../model/product";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  // c/2
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts()
    );
  }


  loadProducts(){
    let idExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");

    if (idExist) {
      let id = this.activatedRoute.snapshot.paramMap.get("id")
      this.getProductByCategoryId(id);
    } else if(keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key")
      this.search(key);
    } else {
      this.getProducts();
    }
  }

  getProducts(): void {
    this.productService.getAllProducts().subscribe(
      response => this.products = response
    )
  }

  getProductByCategoryId(id): void {
    this.productService.getProductsByCategoryId(id).subscribe(
      response => this.products = response
    )
  }

  search(key): void {
    this.productService.search(key).subscribe(
      response => this.products = response
    )
  }
}
