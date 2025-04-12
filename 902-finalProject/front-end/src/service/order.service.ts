import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {OrderDetails} from "../model/order-details";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = 'http://localhost:8085/orders/';
  constructor(private http: HttpClient) { }


  createOrder(totalPrice, totalQuantity, productsIds): Observable<any> {
    return this.http.post(this.baseUrl + 'saveOrder' ,{totalPrice, totalQuantity, productsIds}).pipe(
      map(
        response => response
      )
    )
  }

  getOrderDetails(code): Observable<OrderDetails> {
    return this.http.get<OrderDetails>(this.baseUrl + "orderDetails/code/" + code).pipe(
      map(
        response => response
      )
    )
  }

  getRequestOrdersRelatedToUser(): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(this.baseUrl + "userOrderDetails").pipe(
      map(
        response => response
      )
    )
  }
  getAllRequestOrders(): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(this.baseUrl + "allOrderDetails").pipe(
      map(
        response => response
      )
    )
  }
}
