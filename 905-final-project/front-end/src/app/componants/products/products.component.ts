import {Component, OnInit} from '@angular/core';
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

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts()
    )
  }

  // http://localhost:4200/products
  // http://localhost:4200/category/1
  // http://localhost:4200/search/rice
  loadProducts(){
      // check
      let hasCategoryId = this.activatedRoute.snapshot.paramMap.has("id");
      let hasKey = this.activatedRoute.snapshot.paramMap.has("key");
      if (hasCategoryId){
        let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
        this.getProductByCategoryId(categoryId);
        return;
      } else if (hasKey) {
        let key = this.activatedRoute.snapshot.paramMap.get("key");
        this.searchByKey(key);
        return;
      }

      this.getProducts();
  }


  getProducts(){
    this.productService.getProducts().subscribe(
      value => this.products = value
    )
  }

  getProductByCategoryId(id){
    this.productService.getProductsByCategoryId(id).subscribe(
      value => this.products = value
    )
  }

  searchByKey(key){
    this.productService.search(key).subscribe(
      value => this.products = value
    )
  }
}
