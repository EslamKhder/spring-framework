import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../services/product.service";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../../../services/security/auth.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  page: number = 1;
  pageLength: number = 10;
  collectionSize: number;
  messageAr: string = '';
  messageEn: string = '';
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.getProducts(this.page)
    )
  }

  getProducts(page){
    let idExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (idExist) {
      let id = this.activatedRoute.snapshot.paramMap.get("id");
      this.getAllProductsById(id, page);
    } else if(keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.search(key, page);
    } else {
      this.getAllProducts(page);
    }
  }

  private getAllProducts(page) {
    this.productService.getProducts(page, this.pageLength).subscribe(
      response => {
        this.products = response.products;
        this.collectionSize = response.totalProducts;
        this.messageEn = '';
        this.messageAr = '';
      }, errorResponse => {
        this.products = [];
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    )
  }

  private getAllProductsById(categoryId, page) {
    this.productService.getProductsByCategoryId(categoryId, page, this.pageLength).subscribe(
      response => {
        this.products = response.products;
        this.collectionSize = response.totalProducts;
        this.messageEn = '';
        this.messageAr = '';
      }, errorResponse => {
        this.products = [];
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    )
  }


  private search(key, page) {
    this.productService.search(key, page, this.pageLength).subscribe(
      response => {
        this.products = response.products;
        this.collectionSize = response.totalProducts;
        this.messageEn = '';
        this.messageAr = '';
      }, errorResponse => {
        this.products = [];
        this.messageEn = errorResponse.error.bundleMessage.message_en;
        this.messageAr = errorResponse.error.bundleMessage.message_ar;
      }
    )
  }

  doPagination() {
    this.getProducts(this.page)
  }

  changePageSize(event: Event) {
    this.pageLength = +(<HTMLInputElement>event.target).value;

    this.getProducts(this.page)
  }

  idUserAdmin(){
    return this.authService.isUserAdmin();
  }
}
