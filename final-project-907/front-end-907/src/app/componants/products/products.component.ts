import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute, RouterLink} from "@angular/router";

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
    let idExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (idExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get("id");
      this.getProductsByCategoryId(idCategory);
    } else if (keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.search(key);
    } else {
      this.getAllProducts();
    }
  }


  getAllProducts(){
    this.productService.getProducts().subscribe(
      result => this.products = result
    );
  }

  getProductsByCategoryId(id){
    this.productService.getProductsByCategoryId(id).subscribe(
      result => this.products = result
    );
  }
  search(key){
    this.productService.search(key).subscribe(
      result => this.products = result
    );
  }
}
