import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/product";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[]=[];

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts()
    );
  }

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute){
  }


  loadProducts(){
    let isHasCategoryId = this.activatedRoute.snapshot.paramMap.has("id");
    let isHasKeyWord = this.activatedRoute.snapshot.paramMap.has("key");

    // category/id
    if (isHasCategoryId) {
      let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
      this.getProductsByCategoryId(categoryId);
      return;
    }

    // search/key
    if (isHasKeyWord) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.search(key);
      return;
    }

    this.getProducts();
  }


  getProducts(){
    this.productService.getAllProducts().subscribe(
      value => {
        this.products = value;
        console.log(this.products)
      }
    );
  }

  getProductsByCategoryId(id){
    this.productService.getProductsByCategoryId(id).subscribe(
      value => {
        this.products = value;
        console.log(this.products)
      }
    );
  }
  search(key){
    this.productService.search(key).subscribe(
      value => {
        this.products = value;
        console.log(this.products)
      }
    );
  }

}
