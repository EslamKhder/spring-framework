import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = 'http://localhost:8085/orders/saveOrder';
  constructor(private http: HttpClient) { }


  createOrder(totalPrice, totalQuantity, productsIds): Observable<any> {
    return this.http.post(this.baseUrl ,{totalPrice, totalQuantity, productsIds}).pipe(
      map(
        response => response
      )
    )
  }
}
