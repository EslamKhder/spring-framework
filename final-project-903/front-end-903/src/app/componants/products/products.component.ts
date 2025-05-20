import { Component } from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  products: Product[] = [];

  ngOnInit(): void {
    this.getAllProducts()
  }

  constructor(private productService :ProductService) {
  }

  getAllProducts(){
    this.productService.getAllProducts().subscribe(
      response => {
        this.products = response
      }
    )
  }
}
