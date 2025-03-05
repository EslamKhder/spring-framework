import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CategoryService} from "../../../service/category.service";
import {Category} from "../../../model/category";
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute} from "@angular/router";
import {CartService} from "../../../service/cart.service";
import {CardOrder} from "../../../model/card-order";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  pageNumber: number = 1;
  pageSize: number = 10;
  collectionSize: number;
  products: Product[] = [];
  messageAr: string = '';
  messageEn: string = '';

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private cartService: CartService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.finalProduct(this.pageNumber)
    )
  }


  finalProduct(pageNo){
    debugger
    let categoryIdExist = this.activatedRoute.snapshot.paramMap.has("id");
    let keyExist = this.activatedRoute.snapshot.paramMap.has("key");
    if (categoryIdExist) {
      let categoryId = this.activatedRoute.snapshot.paramMap.get("id");
      this.loadProductByCategoryId(categoryId, pageNo - 1)
    } else if (keyExist && this.activatedRoute.snapshot.paramMap.get("key") !== '') {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.searchProducts(key, pageNo - 1)
    } else {
      this.loadAllProduct(pageNo - 1)
    }
  }


  searchProducts(key, pageNo){
    this.productService.search(key, pageNo,this.pageSize).subscribe(
      response => {
        // @ts-ignore
        if (response && 'status' in response && response.status === 'NO_CONTENT') {
          this.products = [];
          // @ts-ignore
          this.messageAr = response.bundleMessage.message_ar;
          // @ts-ignore
          this.messageEn = response.bundleMessage.message_en;
        } else {
          // @ts-ignore
          this.products = response.products
          // @ts-ignore
          this.collectionSize = response.totalProductSize
        }

      }
    )
  }

  loadProductByCategoryId(categoryId, pageNo){
    this.productService.getProductByCategoryId(categoryId,pageNo ,this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.totalProductSize
        // @ts-ignore
        if (response.products.length === 0) {
          this.messageAr = '🌟 ترقبوا! شيء مذهل قادم قريبًا. 🚀';
          this.messageEn = '🌟 Stay tuned! Something amazing is coming soon. 🚀';
        }
      }
    )
  }

  loadAllProduct(pageNo){
    this.productService.getAllProduct(pageNo, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.totalProductSize
      }
    )
  }

  doPagination() {
    this.finalProduct(this.pageNumber)
  }

  addProduct(product: Product) {
    let order = new CardOrder(product);

    this.cartService.addProductToOrder(order);
  }
}
