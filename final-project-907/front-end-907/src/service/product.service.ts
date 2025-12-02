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

  baseUrl = 'http://localhost:9090/products';
  constructor(private http: HttpClient) { }

  getProducts(page, size): Observable<any> {
    return this.http.get<any>(this.baseUrl + '/all-products?page=' + page + '&size=' + size).pipe(
      map(
        response => response
      )
    )
  }

  getProductsByCategoryId(id,page, size): Observable<any> {
    return this.http.get<any>(this.baseUrl + '/all-products/' + id + "?page=" + page + '&size=' + size).pipe(
      map(
        response => response
      )
    )
  }

  search(key,page, size): Observable<any> {
    return this.http.get<any>(this.baseUrl + '/all-products-by-key?key=' + key+"&page=" + page + '&size=' + size).pipe(
      map(
        response => response
      )
    )
  }

}
