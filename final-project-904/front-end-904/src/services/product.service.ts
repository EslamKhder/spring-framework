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

  baseUrl = 'http://localhost:6060/products';

  constructor(private http: HttpClient) { }

  getProducts(pageNo, pageSize): Observable<any> {
    return this.http.get<Product[]>(this.baseUrl + '/all-products?page=' + pageNo + '&size=' + pageSize).pipe(
      map(
        response => response
      )
    );
  }

  getProductsByCategoryId(categoryId, pageNo, pageSize): Observable<any> {
    return this.http.get<Product[]>(this.baseUrl + "/all-products/" + categoryId +'?page=' + pageNo + '&size=' + pageSize).pipe(
      map(
        response => response
      )
    );
  }

  search(key, pageNo, pageSize): Observable<any> {
    return this.http.get<Product[]>(this.baseUrl + "/all-products-by-key?key=" + key +'&page=' + pageNo + '&size=' + pageSize).pipe(
      map(
        response => response
      )
    );
  }

}
