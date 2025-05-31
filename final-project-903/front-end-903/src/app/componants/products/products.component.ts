import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute} from "@angular/router";
import {CardService} from "../../../service/card.service";
import {CardOrder} from "../../../model/card-order";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent  implements OnInit  {
  products: Product[] = [];
  pageNumber: number = 1;
  pageSize: number = 5;
  collectionSize: number;
  messageAr: string = '';
  messageEn: string = '';
  isCategoryProductExist: boolean = false;
  isProductExist: boolean = false;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () =>  this.handelAllAction(this.pageNumber)
    )
  }

  constructor(private productService :ProductService, private activatedRoute: ActivatedRoute, private cardService: CardService) {
  }

  handelAllAction(pageNumber){
    let idCategoryExist = this.activatedRoute.snapshot.paramMap.has("id");
    let idKeyExist = this.activatedRoute.snapshot.paramMap.has("key");

    if (idCategoryExist && idKeyExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get("id");
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.searchByCategoryIdAndKey(idCategory, key, pageNumber);
      return;
    }

    if (idCategoryExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get("id");
      this.getProductByCategoryId(idCategory, pageNumber)
    } else if (idKeyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get("key");
      this.getProductByKey(key, pageNumber)
    } else {
      this.getAllProducts(pageNumber)
    }
  }

  searchByCategoryIdAndKey(id, key, pageNumber){
    this.productService.searchByCategoryIdAndKey(id, key, pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products;
        // @ts-ignore
        this.collectionSize = response.totalProducts;
        this.isCategoryProductExist = false;
        this.isProductExist = false;
      }, errors => {
        this.products = []
        this.collectionSize = 0
        // @ts-ignore
        this.messageAr = errors.error.bundleMessage.message_ar
        // @ts-ignore
        this.messageEn = errors.error.bundleMessage.message_en
        this.isCategoryProductExist = false;
        this.isProductExist = true;
      }
    )
  }
  getAllProducts(pageNumber){
    this.productService.getAllProducts(pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.totalProducts
        if (this.products.length === 0) {
          this.isCategoryProductExist = true;
        }
        this.isProductExist = false;
      }
    )
  }

  // category id   not exist product  isCategoryProductExist = true
  // category id   exist product

  getProductByCategoryId(id, pageNumber){
    this.productService.getProductsByCategoryId(id, pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.totalProducts

        if (this.products.length === 0) {
          this.isCategoryProductExist = true;
        } else {
          this.isCategoryProductExist = false;
        }

        this.isProductExist = false;
      }
    )
  }

  /*
        this.isCategoryProductExist = false;
        this.isProductExist = true;
   */
  getProductByKey(key, pageNumber){
    this.productService.getProductsByKey(key, pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.totalProducts
        this.isCategoryProductExist = false;
        this.isProductExist = false;
      }, errors => {
        this.products = []
        this.collectionSize = 0
        // @ts-ignore
        this.messageAr = errors.error.bundleMessage.message_ar
        // @ts-ignore
        this.messageEn = errors.error.bundleMessage.message_en
        this.isCategoryProductExist = false;
        this.isProductExist = true;
      }
    )
  }

  addProductToCard(product: Product){
    let order = new  CardOrder(product);
    this.cardService.addProductTOrder(order);
  }
  doPagination() {
    this.handelAllAction(this.pageNumber)
  }

  changePageSize(event: Event) {
    this.pageSize = +(<HTMLInputElement>event.target).value;
    this.handelAllAction(this.pageNumber)
  }
}
