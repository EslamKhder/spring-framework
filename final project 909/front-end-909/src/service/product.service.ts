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

  baseUrl = "http://localhost:6060/products";

  constructor(private http: HttpClient) {
  }


  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "/all-products").pipe(
      map(
        response => response
      )
    );
  }

  getProductsByCategoryId(id): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "/all-products/" + id).pipe(
      map(
        response => response
      )
    );
  }
  // http://localhost:9090/api/products
  search(key): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "/all-products-by-key?key=" + key).pipe(
      map(
        response => response
      )
    );
  }
}
