import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RequestOrderService {

  url = 'http://localhost:9090/orders/';

  constructor(private http: HttpClient) { }

  createOrder(productsIds, totalPrice, totalNumber): Observable<any> {
    return this.http.post<any>(this.url + 'create-orders' , {productsIds, totalPrice, totalNumber}).pipe(
      map(
        response => response
      )
    );
  }

  getOrder(): Observable<any> {
    return this.http.get<any>(this.url + 'all-orders').pipe(
      map(
        response => response
      )
    );
  }
}
