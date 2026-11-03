import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent  implements OnInit{

  products: Product[] = [];

  ngOnInit(): void {
    this.getProducts();
  }

  constructor(private productService: ProductService) {
  }


  getProducts(): void {
    this.productService.getAllProducts().subscribe(
      response => this.products = response
    );
  }



}

