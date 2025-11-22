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

  page: number = 1; // 1
  pageLength: number = 10;
  collectionSize: number;
  products: Product[] = [];
  messageAr: string = "";
  messageEn: string = "";
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
    this.productService.getAllProducts(this.page, this.pageLength).subscribe(
      value => {
        this.messageAr = '';
        this.messageEn = '';
        this.products = value.products;
        this.collectionSize = value.totalProducts;
      }
    )
  }

  getProductsByCategoryId(id){
    this.productService.getProductsByCategoryId(id,this.page, this.pageLength).subscribe(
      value => {
        this.messageAr = '';
        this.messageEn = '';
        this.products =value.products;
        this.collectionSize = value.totalProducts;
      } , errorResponse => {
        this.products = [];
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    )
  }


  search(key){
    this.productService.search(key,this.page, this.pageLength).subscribe(
      value => {
        this.messageAr = '';
        this.messageEn = '';
        this.products = value.products;
        this.collectionSize = value.totalProducts;
      }, errorResponse => {
        this.products = [];
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    )
  }

  doPag() {
    this.getAllProducts();
  }

  changeSize(event: Event) {
    this.pageLength = +(<HTMLInputElement>event.target).value;
    this.getAllProducts();
  }
}
