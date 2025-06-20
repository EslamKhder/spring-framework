import { Injectable } from '@angular/core';
import {CardOrder} from "../model/card-order";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CardService {

  orders: CardOrder[] = [];
  totalSize: Subject<number> = new BehaviorSubject<number>(0);
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);

  // case 1 : order first to add
  // case 2 : order already exist add new one
  addProductToOrder(newOrder: CardOrder) {
    // NULL
    // undefined
    let isExist: boolean = false;
    let existedOrder: CardOrder = undefined;

    if(this.orders.length > 0){
      existedOrder = this.orders.find(order => order.id === newOrder.id)
    }

    // existedOrder  undefined   --
    isExist = (existedOrder !== undefined) // false  true


    if (isExist) {
      existedOrder.quantity++
    } else {
      this.orders.push(newOrder)
    }

    console.log(this.orders)

    this.calculateTotals()
    console.log(this.totalSize)
    console.log(this.totalPrice)
  }

  calculateTotals(){
    let totalElementSize: number = 0;
    let totalElementPrice: number = 0;

    for (let temp of this.orders){
      totalElementSize += temp.quantity
      totalElementPrice += temp.quantity * temp.price
    }

    this.totalSize.next(totalElementSize);
    this.totalPrice.next(totalElementPrice);
  }

  decrementOrder(order: CardOrder){ // 1    2 3 4 5 6
    order.quantity--;
    if(order.quantity === 0){
      this.removeOrder(order)
    }
  }

  removeOrder(removedOrder: CardOrder){
    let index = this.orders.findIndex(order => order.id === removedOrder.id) // index 2
    if(index > -1) {
      this.orders.splice(index, 1);
    }
    this.calculateTotals()
  }

}
