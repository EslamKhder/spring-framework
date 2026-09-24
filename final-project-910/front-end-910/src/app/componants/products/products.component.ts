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
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.getProducts()
    );
  }

  getProducts(){
    debugger
    // id
    let idExist = this.activatedRoute.snapshot.paramMap.has('id');
    let keyExist = this.activatedRoute.snapshot.paramMap.has('key');
    if (idExist) {
      let id = this.activatedRoute.snapshot.paramMap.get('id');
      this.productService.getProductsByCategoryId(id).subscribe(
        response => this.products = response
      );
    } else if (keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get('key');
      this.productService.search(key).subscribe(
        response => this.products = response
      );
    } else {
      this.productService.getProducts().subscribe(
        response => this.products = response
      );
    }


  }

}
