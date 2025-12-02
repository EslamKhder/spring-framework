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
  messageAr: string = "";
  messageEn: string = "";

  page: number = 1;
  pageSize: number = 10;
  collectionSize: number;

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    // this.loadProducts()
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts()
    )
  }



  loadProducts(){
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
    this.productService.getProducts(this.page, this.pageSize).subscribe(
      result => {
        this.products = result.products;
        this.collectionSize = result.totalProducts;
        this.messageAr = "";
        this.messageEn = "";
      }, errorResponse => {
        this.products = [];
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
        this.messageEn = errorResponse.error.bundleMessage.message_en;
      }
    )
  }

  getProductsByCategoryId(id){
    this.productService.getProductsByCategoryId(id,this.page, this.pageSize).subscribe(
      result => {
        this.products = result.products;
        this.collectionSize = result.totalProducts;
        this.messageAr = "";
        this.messageEn = "";
      }, errorResponse => {
        this.products = [];
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
        this.messageEn = errorResponse.error.bundleMessage.message_en;
      }
    )
  }
  search(key){
    this.productService.search(key, this.page, this.pageSize).subscribe(
      result => {
        this.products = result.products;
        this.collectionSize = result.totalProducts;
        this.messageAr = "";
        this.messageEn = "";
      }, errorResponse => {
        this.products = [];
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
        this.messageEn = errorResponse.error.bundleMessage.message_en;
      }
    )
  }

  doPagination() {
    this.loadProducts();
  }

  changePageSize(event: Event) {
    this.pageSize = +(<HTMLInputElement>event.target).value;
    this.loadProducts();
  }
}
