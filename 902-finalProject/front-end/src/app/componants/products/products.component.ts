import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CategoryService} from "../../../service/category.service";
import {Category} from "../../../model/category";
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[] = [];
  messageAr: string = '';
  messageEn: string = '';

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.finalProduct()
    )
  }


  finalProduct(){
    let categoryIdExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (categoryIdExist) {
      let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
      this.loadProductByCategoryId(categoryId)
    } else if (keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.searchProducts(key)
    } else {
      this.loadAllProduct()
    }
  }


  searchProducts(key){
    this.productService.search(key).subscribe(
      response => {
        // @ts-ignore
        if (response && 'status' in response && response.status === 'NO_CONTENT') {
          this.products = [];
          // @ts-ignore
          this.messageAr = response.bundleMessage.message_ar;
          // @ts-ignore
          this.messageEn = response.bundleMessage.message_en;
        } else {
          this.products = response
        }

      }
    )
  }

  loadProductByCategoryId(categoryId){
    this.productService.getProductByCategoryId(categoryId).subscribe(
      response => {
        this.products = response
        if (response.length === 0) {
          this.messageAr = '🌟 ترقبوا! شيء مذهل قادم قريبًا. 🚀';
          this.messageEn = '🌟 Stay tuned! Something amazing is coming soon. 🚀';
        }
      }
    )
  }
  loadAllProduct(){
    this.productService.getAllProduct().subscribe(
      response => {
        this.products = response
      }
    )
  }

}
