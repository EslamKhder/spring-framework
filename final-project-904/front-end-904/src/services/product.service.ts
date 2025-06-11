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

  baseUrl = 'http://localhost:9090/api/products';

  constructor(private http: HttpClient) { }

  getProducts(pageNo, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + '/getAll/pageNo/' + pageNo + '/pageSize/' + pageSize).pipe(
      map(
        response => response
      )
    );
  }

  getProductsByCategoryId(categoryId, pageNo, pageSize): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "/searchByCategoryId/" + categoryId + '/pageNo/' + pageNo + '/pageSize/' + pageSize).pipe(
      map(
        response => response
      )
    );
  }

  search(key): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "/search?keyword=" + key).pipe(
      map(
        response => response
      )
    );
  }

}
