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

  baseUrl = 'http://localhost:6060/api/products';

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl + "/getAll").pipe(
      map(
        response => response
      )
    );
  }

  getProductsByCategoryId(id): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl + "/searchByCategoryId/" + id).pipe(
      map(
        response => response
      )
    );
  }

  search(keyword): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl + "/search?keyword=" + keyword).pipe(
      map(
        response => response
      )
    );
  }



}
