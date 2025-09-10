import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute} from "@angular/router";
import {CartService} from "../../../service/cart.service";
import {ProductOrder} from "../../../model/product-order";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})

export class ProductsComponent  implements OnInit{

  messageAr: string = '';
  messageEn: string = '';
  products: Product[] = [];
  pageNumber: number = 1;
  pageSize: number = 20;
  totalProductSize: number;
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute,
              private cartService: CartService) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.loadProducts(this.pageNumber)
    )
  }

  // http://localhost:4200/products
  // http://localhost:4200/category/1
  // http://localhost:4200/search/rice
  loadProducts(pageNum){
      // check
      let hasCategoryId = this.activatedRoute.snapshot.paramMap.has("id");
      let hasKey = this.activatedRoute.snapshot.paramMap.has("key");
      if (hasCategoryId){
        let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
        this.getProductByCategoryId(categoryId, pageNum);
        return;
      } else if (hasKey) {
        let key = this.activatedRoute.snapshot.paramMap.get("key");
        this.searchByKey(key, pageNum);
        return;
      }

      this.getProducts(pageNum);
  }


  getProducts(pageNum){
    this.productService.getProducts(pageNum, this.pageSize).subscribe(
      response => {
        this.products = response.products;
        this.totalProductSize = response.totalProducts
      }, error => {
        this.messageAr = error.error.bundleMessage.message_ar;
        this.messageEn = error.error.bundleMessage.message_en;
        this.products = [];
      }
    )
  }

  getProductByCategoryId(id, pageNum){
    this.productService.getProductsByCategoryId(id, pageNum, this.pageSize).subscribe(
      response => {
        this.products = response.products;
        this.totalProductSize = response.totalProducts
      }, error => {
        this.messageAr = error.error.bundleMessage.message_ar;
        this.messageEn = error.error.bundleMessage.message_en;
        this.products = [];
      }
    )
  }

  searchByKey(key, pageNum){
    this.productService.search(key, pageNum, this.pageSize).subscribe(
      response => {
        this.products = response.products;
        this.totalProductSize = response.totalProducts
      }, error => {
        this.messageAr = error.error.bundleMessage.message_ar;
        this.messageEn = error.error.bundleMessage.message_en;
        this.products = [];
      }
    )
  }

  pagination() {
   this.loadProducts(this.pageNumber)
  }

  changePageSize(event: Event) {
    this.pageSize = +(<HTMLInputElement>event.target).value
    this.loadProducts(this.pageNumber)
  }

  addProduct(product: Product){
    let productOrder = new ProductOrder(product);
    this.cartService.addProductToOrder(productOrder);

  }
}
