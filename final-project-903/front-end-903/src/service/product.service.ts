import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:9090/api/products'
  constructor(private http: HttpClient) { }

  getAllProducts(pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/getAll?pageNumber=${pageNumber}&pageSize=${pageSize}`).pipe(
    // return this.http.get<Product[]>(this.baseUrl + '/getAll?pageNumber=' + pageNumber + '&pageSize=' + pageSize).pipe(
      map(
        response => response
      )
    )
  }

  getProductsByCategoryId(id,pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/searchByCategoryId/${id}?pageNumber=${pageNumber}&pageSize=${pageSize}`).pipe(
    // return this.http.get<Product[]>(this.baseUrl + '/searchByCategoryId/' + id).pipe(
      map(
        response => response
      )
    )
  }

  getProductsByKey(key, pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/search?keyword=${key}&pageNumber=${pageNumber}&pageSize=${pageSize}`).pipe(
    // return this.http.get<Product[]>(this.baseUrl + '/search?keyword=' + key).pipe(
      map(
        response => response
      )
    )
  }

  searchByCategoryIdAndKey(id, key, pageNumber, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/categorySearch?categoryId=${id}&keyword=${key}&pageNumber=${pageNumber}&pageSize=${pageSize}`).pipe(
      // return this.http.get<Product[]>(this.baseUrl + '/search?keyword=' + key).pipe(
      map(
        response => response
      )
    )
  }

}
