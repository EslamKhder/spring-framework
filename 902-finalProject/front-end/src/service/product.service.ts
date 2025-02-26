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

  baseUrl = 'http://localhost:8085/product';
  constructor(private http: HttpClient) { }


  getAllProduct(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl).pipe(
      map(
        response => response
      )
    )
  }

  getProductByCategoryId(categoryId): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + '/category/categoryId/' + categoryId).pipe(
      map(
        response => response
      )
    )
  }

  search(key): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + '/search/' + key).pipe(
      map(
        response => response
      )
    )
  }
}
