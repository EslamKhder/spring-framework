import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:6060/products'
  constructor(private http: HttpClient) { }

  getAllProducts(pageNumber, pageSize): Observable<any> {
    return this.http.get<Product[]>(`${this.baseUrl}/all-products?page=${pageNumber}&size=${pageSize}`).pipe(
    // return this.http.get<Product[]>(this.baseUrl + '/getAll?page=' + pageNumber + '&size=' + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  getProductsByCategoryId(id,pageNumber, pageSize): Observable<any> {
    return this.http.get<Product[]>(`${this.baseUrl}/all-products/${id}?page=${pageNumber}&size=${pageSize}`).pipe(
    // return this.http.get<Product[]>(this.baseUrl + '/searchByCategoryId/' + id).pipe(
      map(
        response => response
      )
    )
  }

  getProductsByKey(key, pageNumber, pageSize): Observable<any> {
    return this.http.get<Product[]>(`${this.baseUrl}/all-products-by-key?key=${key}&page=${pageNumber}&size=${pageSize}`).pipe(
    // return this.http.get<Product[]>(this.baseUrl + '/search?keyword=' + key).pipe(
      map(
        response => response
      )
    )
  }

  searchByCategoryIdAndKey(id, key, pageNumber, pageSize): Observable<any> {
    return this.http.get<Product[]>(`${this.baseUrl}/all-products-by-key-and-category-id?categoryId=${id}&key=${key}&page=${pageNumber}&size=${pageSize}`).pipe(
      // return this.http.get<Product[]>(this.baseUrl + '/search?keyword=' + key).pipe(
      map(
        response => response
      )
    )
  }

}
