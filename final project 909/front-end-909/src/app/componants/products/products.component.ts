import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Category} from "../../../model/category";
import {Product} from "../../../model/product";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  messageAr: string = "";
  messageEn: string = "";
  page: number = 1;
  pageSize: number = 5;
  collectionSize: number = 0;
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  // c/2
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts(this.page, this.pageSize)
    );
  }


  loadProducts(page, size){
    let idExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");

    if (idExist) {
      let id = this.activatedRoute.snapshot.paramMap.get("id")
      this.getProductByCategoryId(id, page, size);
    } else if(keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key")
      this.search(key, page, size);
    } else {
      this.getProducts(page, size);
    }
  }

  getProducts(page, size): void {
    this.productService.getAllProducts(page, size).subscribe(
      response => {
        this.products = response.products
        this.collectionSize = response.totalProducts
        this.messageEn = ""
        this.messageAr = ""
      } , error => {
        this.products = [];
        this.collectionSize = 0;
        this.messageEn = error.error.bundleMessage.message_ar;
        this.messageAr = error.error.bundleMessage.message_en;
      }
    )
  }

  getProductByCategoryId(id, page, size): void {
    this.productService.getProductsByCategoryId(id, page, size).subscribe(
      response => {
        this.products = response.products
        this.collectionSize = response.totalProducts
        this.messageEn = ""
        this.messageAr = ""
      } , error => {
        this.products = [];
        this.collectionSize = 0;
        this.messageEn = error.error.bundleMessage.message_ar;
        this.messageAr = error.error.bundleMessage.message_en;
      }
    )
  }

  search(key, page, size): void {
    this.productService.search(key,page, size).subscribe(
      response => {
        this.products = response.products
        this.collectionSize = response.totalProducts
        this.messageEn = ""
        this.messageAr = ""
      } , error => {
        this.products = [];
        this.collectionSize = 0;
        this.messageEn = error.error.bundleMessage.message_ar;
        this.messageAr = error.error.bundleMessage.message_en;
      }
    )
  }

  pagination() {
    this.loadProducts(this.page, this.pageSize);
  }

  changePageSize(event: Event) {
    this.pageSize = +(<HTMLInputElement>event.target).value;
    this.loadProducts(this.page, this.pageSize);
  }
}
