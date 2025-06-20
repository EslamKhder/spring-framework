import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CardRequestService {

  url = 'http://localhost:6060/orders/create-orders';

  constructor(private http: HttpClient) { }

  createOrder(productsIds, totalPrice, totalNumber): Observable<any> {
    return this.http.post<any>(this.url , {productsIds, totalPrice, totalNumber}).pipe(
      map(
        response => response
      )
    );
  }
}
