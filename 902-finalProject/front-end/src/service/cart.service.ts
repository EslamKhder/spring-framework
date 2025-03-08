import { Injectable } from '@angular/core';
import {CardOrder} from "../model/card-order";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  order: CardOrder[] = []; // o1, o2 ,o3 o4
  totalOrdersSize: Subject<number> = new BehaviorSubject<number>(0);
  totalOrdersPrice: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  // case 1    order empty     order
  // case 2    order not empty    add order and new order not exist
  // case 3    order not empty    add order and new order exist
  addProductToOrder(order: CardOrder) {
    let isExist : boolean = false;
    let existedOrder : CardOrder = undefined;

    if(this.order.length !== 0){
      existedOrder =  this.order.find(o => o.id === order.id);
    }

    isExist = (existedOrder != undefined);

    if (isExist){
      existedOrder.quantity++;
    } else {
      this.order.push(order)
    }

    console.log(this.order)

    this.calculateTotals()
  }

  calculateTotals(){
    let totalNumber: number = 0;
    let totalPrice: number = 0;

    for(let temp of this.order){
      totalNumber += temp.quantity;
      totalPrice +=  temp.quantity *  temp.price;
    }

    this.totalOrdersSize.next(totalNumber)
    this.totalOrdersPrice.next(totalPrice)
  }



  //                            0   1  2   3
  //order: CardOrder[] = []; // o1, o2 ,o3 o4
  removeOrder(order: CardOrder) {
    debugger
    const index = this.order.findIndex(o => o.id === order.id); //1

    if (index > -1){
      this.order.splice(index, 1);
    }

    this.calculateTotals()
  }

  //  case   order    qu > 1
  //  case   order    qu = 1
  deCreaseOrder(order: CardOrder) {
    order.quantity--;   // 5  4

    if (order.quantity === 0){
      this.removeOrder(order)
    } else {
      this.calculateTotals()
    }
  }
}
