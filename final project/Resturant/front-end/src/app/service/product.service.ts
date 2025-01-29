import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {map} from "rxjs/operators";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:9090/product';
  allProductUrl = 'http://localhost:9090/product/getProducts/';
  productByCategoryIdUrl = 'http://localhost:9090/product/getProductsBy/';
  productSearchUrl = 'http://localhost:9090/product/getProductsByletter/';
  constructor(private http: HttpClient) { }


  getAllProduct(pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.allProductUrl + "pageNumber/" + pageNumber +"/pageSize/" + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  getProductById(categoryId, pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.productByCategoryIdUrl + categoryId + "/pageNumber/" + pageNumber +"/pageSize/" + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  getProductByKey(key, pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.productSearchUrl + key + "/pageNumber/" + pageNumber +"/pageSize/" + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  getProductSize(): Observable<number> {
    return this.http.get<number>(this.baseUrl + "/getProductSize").pipe(
      map(
        response => response
      )
    )
  }

  getProductSizeByCategoryId(categoryId): Observable<number> {
    return this.http.get<number>(this.baseUrl + "/getProductSizeByCategoryId/" + categoryId).pipe(
      map(
        response => response
      )
    )
  }

  getProductSizeByKey(key): Observable<number> {
    return this.http.get<number>(this.baseUrl + "/getProductSizeByKey/" + key).pipe(
      map(
        response => response
      )
    )
  }
}
