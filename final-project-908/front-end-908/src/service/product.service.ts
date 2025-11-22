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
  constructor(private http: HttpClient) { }


  getAllProducts(pageNumber, pageSize): Observable<any> {
    return this.http.get<any>(this.baseUrl + "/all-products?page=" + pageNumber + "&size=" + pageSize).pipe(
      map(
        response => response
      )
    );
  }
  getProductsByCategoryId(id, pageNumber, pageSize): Observable<any> {
    return this.http.get<any>(this.baseUrl + "/all-products/" + id + "?page=" + pageNumber + "&size=" + pageSize).pipe(
      map(
        response => response
      )
    );
  }

  search(key, pageNumber, pageSize): Observable<any> {
    return this.http.get<any>(this.baseUrl + "/all-products-by-key?key=" + key + "&page=" + pageNumber + "&size=" + pageSize).pipe(
      map(
        response => response
      )
    );
  }

}
