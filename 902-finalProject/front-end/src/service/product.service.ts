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


  getAllProduct(pageNo, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + '/pageNo/' + pageNo + '/pageSize/' + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  getProductByCategoryId(categoryId, pageNo, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + '/category/categoryId/' + categoryId+ '/pageNo/' + pageNo + '/pageSize/' + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  search(key, pageNo, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + '/search/' + key+ '/pageNo/' + pageNo + '/pageSize/' + pageSize).pipe(
      map(
        response => response
      )
    )
  }
}
