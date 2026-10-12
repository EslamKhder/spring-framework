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
export class ProductsComponent implements OnInit {

  products: Product[] = []; // 50
  pageNumber: number = 1;
  pageSize: number = 10;
  totalProductSize: number;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.getProducts()
    );
  }

  getProducts(){
    // id
    let idExist = this.activatedRoute.snapshot.paramMap.has('id');
    let keyExist = this.activatedRoute.snapshot.paramMap.has('key');
    if (idExist) {
      let id = this.activatedRoute.snapshot.paramMap.get('id');
      this.productService.getProductsByCategoryId(id, this.pageNumber, this.pageSize).subscribe(
        response => {
          this.products = response.products;
          this.totalProductSize = response.totalProducts
        }
      );
    } else if (keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get('key');
      this.productService.search(key, this.pageNumber, this.pageSize).subscribe(
        response => {
          this.products = response.products;
          this.totalProductSize = response.totalProducts
        }
      );
    } else {
      this.productService.getProducts(this.pageNumber, this.pageSize).subscribe(
        response => {
          this.products = response.products;
          this.totalProductSize = response.totalProducts
        }
      );
    }


  }

  doing() {
    this.getProducts();
  }

  changeSize(event: Event) {
    this.pageSize = +(<HTMLInputElement>event.target).value;
    this.getProducts();
  }
}
