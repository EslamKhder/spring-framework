import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../services/category.service";
import {Product} from "../../../model/product";
import {ProductService} from "../../../services/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  page: number = 1;
  pageLength: number = 20;
  collectionSize: number = 60;
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.getProducts()
    )
  }

  getProducts(){
    debugger
    let idExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (idExist) {
      let id = this.activatedRoute.snapshot.paramMap.get("id");
      this.getAllProductsById(id);
    } else if(keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.search(key);
    } else {
      this.getAllProducts();
    }
  }

  private getAllProducts() {
    this.productService.getProducts(this.page, this.pageLength).subscribe(
      response => this.products = response
    )
  }

  private getAllProductsById(categoryId) {
    this.productService.getProductsByCategoryId(categoryId, this.page, this.pageLength).subscribe(
      response => this.products = response
    )
  }


  private search(key) {
    this.productService.search(key).subscribe(
      response => this.products = response
    )
  }

  doPagination() {
    alert("doPagination")
  }
}
