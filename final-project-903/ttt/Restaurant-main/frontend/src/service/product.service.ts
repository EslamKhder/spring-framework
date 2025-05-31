import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:9091/api/products/';

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.http
      .get<Product[]>(this.baseUrl + "getAll").pipe(
        map(resp => resp)
      )
  }

  getProductsByCategoryId(id): Observable<Product[]> {
    return this.http
      .get<Product[]>(this.baseUrl + 'searchByCategoryId/' + id).pipe(
        map(resp => resp)
      )
  }

  searchByNameOrDescription(key): Observable<Product[]> {
    return this.http
      .get<Product[]>(this.baseUrl + 'search?keyword=' + key).pipe(
        map(resp => resp)
      )
  }
}
