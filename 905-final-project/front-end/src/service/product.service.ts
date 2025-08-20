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

  productUrl = 'http://localhost:9090/api/products/getAll';
  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl).pipe(
      map(
        response => response
      )
    )
  }
}
