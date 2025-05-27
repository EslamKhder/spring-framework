import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute} from "@angular/router";

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

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () =>  this.handelAllAction(this.pageNumber)
    )
  }

  constructor(private productService :ProductService, private activatedRoute: ActivatedRoute) {
  }

  handelAllAction(pageNumber){
    let idCategoryExist = this.activatedRoute.snapshot.paramMap.has("id");
    let idKeyExist = this.activatedRoute.snapshot.paramMap.has("key");

    debugger
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
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.size
      }
    )
  }
  getAllProducts(pageNumber){
    this.productService.getAllProducts(pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.size
      }
    )
  }

  getProductByCategoryId(id, pageNumber){
    this.productService.getProductsByCategoryId(id, pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.size
      }
    )
  }

  getProductByKey(key, pageNumber){
    this.productService.getProductsByKey(key, pageNumber, this.pageSize).subscribe(
      response => {
        // @ts-ignore
        this.products = response.products
        // @ts-ignore
        this.collectionSize = response.size
      }
    )
  }

  doPagination() {
    this.handelAllAction(this.pageNumber)
  }

  changePageSize(event: Event) {
    this.pageSize = +(<HTMLInputElement>event.target).value;
    this.handelAllAction(this.pageNumber)
  }
}
