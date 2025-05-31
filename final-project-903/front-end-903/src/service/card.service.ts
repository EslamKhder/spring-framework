import { Injectable } from '@angular/core';
import {CardOrder} from "../model/card-order";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CardService {

  orders: CardOrder[] = [];
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalOrdersSize: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  addProductTOrder(order: CardOrder) {
    let isExist: boolean = false;
    let existedOrder: CardOrder = undefined;

    // undefined

    if (this.orders.length > 0) {
      existedOrder = this.orders.find(orderCard => orderCard.id === order.id );
      console.log("---> " + this.orders.find(orderCard => orderCard.id === order.id ));
    }

    // undefined
    // order
    isExist = (existedOrder !== undefined);
    // undefined false   order true

    if (isExist){
      existedOrder.quantity++;
    } else {
      this.orders.push(order);
    }
    console.log(this.orders)

    this.calculateTotals();
  }

  calculateTotals(){
    let totalElementSize: number = 0;
    let totalElementPrice: number = 0;

    for (let temp of this.orders) {
      totalElementSize += temp.quantity;
      totalElementPrice += temp.quantity * temp.price;
    }

    console.log(totalElementSize)
    console.log(totalElementPrice)

    this.totalOrdersSize.next(totalElementSize)
    this.totalPrice.next(totalElementPrice)
  }


  // case 1 :   order   1   0
  // case 2 :   order   > 1
  removeOrder(order: CardOrder){
    order.quantity--;

    if(order.quantity === 0){
      this.remove(order)
    }
  }

  //  0  1 2  3
  // [5,10,15,20]     1

  remove(order: CardOrder) {
    let index = this.orders.findIndex(orderCard => orderCard.id === order.id); // -
    if (index > -1) {
      this.orders.splice(index, 1)
    }

    this.calculateTotals();
  }


}
