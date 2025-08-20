import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent  implements OnInit{

  products: Product[] = [];

  constructor(private productService: ProductService) {

  }

  ngOnInit(): void {
    this.getProducts()
  }

  getProducts(){
    this.productService.getProducts().subscribe(
      value => this.products = value
    )
  }
}
