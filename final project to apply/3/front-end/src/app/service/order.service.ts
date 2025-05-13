import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  createOrderUrl = 'http://localhost:9090/orders/saveOrder';
  constructor(private http: HttpClient) { }


  createOrder(totalQuantity, totalPrice, productsIds): Observable<any> {
    return this.http.post(this.createOrderUrl, {totalQuantity, totalPrice, productsIds}).pipe(
      map(
        response => response
      )
    )
  }
}
