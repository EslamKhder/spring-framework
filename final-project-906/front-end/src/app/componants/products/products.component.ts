import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/product";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[]=[];

  ngOnInit(): void {
    this.getProducts();
  }

  constructor(private productService: ProductService){
  }

  getProducts(){
    this.productService.getAllProducts().subscribe(
      value => {
        this.products = value;
        console.log(this.products)
      }
    );
  }

}
