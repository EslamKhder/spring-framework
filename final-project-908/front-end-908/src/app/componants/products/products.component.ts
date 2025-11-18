import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
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

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.getAllProducts()
    );

  }

  getAllProducts(){

    let isIdExist = this.activatedRoute.snapshot.paramMap.has('id');
    let isKeyExist = this.activatedRoute.snapshot.paramMap.has('key');
    if (isIdExist) {
      let id = this.activatedRoute.snapshot.paramMap.get('id');
      this.getProductsByCategoryId(id);
    } else if (isKeyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get('key');
      this.search(key);
    } else {
      this.getProducts();
    }
  }
  getProducts()
  {
    this.productService.getAllProducts().subscribe(
      value => {
        this.products = value;
      }
    )
  }

  getProductsByCategoryId(id){
    this.productService.getProductsByCategoryId(id).subscribe(
      value => {
        this.products = value;
      }
    )
  }


  search(key){
    this.productService.search(key).subscribe(
      value => {
        this.products = value;
      }
    )
  }
}
