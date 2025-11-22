import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/product";
import {ActivatedRoute, Router} from "@angular/router";
import {CardService} from "../../../service/card.service";
import {CardItem} from "../../../model/card-item";
import {AuthService} from "../../../service/security/auth.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[]=[];

  messageAr: string = "";
  messageEn: string = "";

  page: number = 1;
  pageLength: number = 10;
  collectionSize: number;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts()
    );
  }

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute,
              private cardService: CardService, private authService: AuthService){
  }


  loadProducts(){
    let isHasCategoryId = this.activatedRoute.snapshot.paramMap.has("id");
    let isHasKeyWord = this.activatedRoute.snapshot.paramMap.has("key");

    // category/id
    if (isHasCategoryId) {
      let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
      this.getProductsByCategoryId(categoryId, this.page, this.pageLength);
      return;
    }

    // search/key
    if (isHasKeyWord) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.search(key, this.page, this.pageLength);
      return;
    }

    this.getProducts(this.page, this.pageLength);
  }


  getProducts(pageNumber, pageSize){
    this.productService.getAllProducts(pageNumber, pageSize).subscribe(
      value => {
        this.products = value.products;
        this.collectionSize = value.totalProducts;
        this.messageAr = "";
        this.messageEn = "";
      }, invalidResponse => {
        this.products = [];
        this.messageAr = invalidResponse.error.bundleMessage.message_ar
        this.messageEn = invalidResponse.error.bundleMessage.message_en
      }
    );
  }

  getProductsByCategoryId(id, pageNumber, pageSize){
    this.productService.getProductsByCategoryId(id, pageNumber, pageSize).subscribe(
      value => {
        this.products = value.products;
        this.collectionSize = value.totalProducts;
        this.messageAr = "";
        this.messageEn = "";
      }, invalidResponse => {
        this.products = [];
        this.messageAr = invalidResponse.error.bundleMessage.message_ar
        this.messageEn = invalidResponse.error.bundleMessage.message_en
      }
    );
  }
  search(key, pageNumber, pageSize){
    this.productService.search(key, pageNumber, pageSize).subscribe(
      value => {
        this.products = value.products;
        this.collectionSize = value.totalProducts;
        this.messageAr = "";
        this.messageEn = "";
      }, invalidResponse => {
        this.products = [];
        this.messageAr = invalidResponse.error.bundleMessage.message_ar
        this.messageEn = invalidResponse.error.bundleMessage.message_en
      }
    );
  }

  pageChange(){
    this.loadProducts()
  }

  changePageSize(event: Event) {
    this.pageLength = +(<HTMLInputElement>event.target).value;
    this.loadProducts()
  }

  addProduct(product: Product){
    let cardItem = new CardItem(product);
    this.cardService.addProduct(cardItem);
  }

  isUserAdmin(){
    return this.authService.isUserAdmin();
  }

  editProduct(pro: Product) {

  }

  deleteProduct(pro: Product) {

  }
}
