import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {CartOrder} from "../model/cart-order";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  orders: CartOrder[] = [];
  totalPrice: Subject<number> = new BehaviorSubject(0);
  totalNumber: Subject<number> = new BehaviorSubject(0);

  constructor() { }

  // case 1 orders empty  cartOrder add direct
  // case 2 orders not empty  cartOrder not exist on orders add direct
  // case 3 orders not empty  cartOrder exist on orders inc quantity ++
  addOrder(cartOrder: CartOrder){
    let isExist: boolean = false;
    let existedOrder: CartOrder = undefined;

    // =         a = 5;
    // ==        5 == 5     "5" == 5    '5' == "5"     5 == '5'
    // ===       5 == 5     "5" == 5    '5' == "5"     5 == '5'
    if (this.orders.length > 0) {
      existedOrder = this.orders.find(order => order.id === cartOrder.id);
    }

    isExist = (existedOrder !== undefined);

    if (isExist) {
      existedOrder.quantity++;
    } else {
      this.orders.push(cartOrder);
    }

    this.calculateTotals();

    console.log(JSON.stringify(this.orders));
    console.log(this.totalNumber);
    console.log(this.totalPrice);
  }


  calculateTotals(){
    let totalSize: number =  0;
    let totalPrice: number =  0;

    for (let order of this.orders) {
      totalSize += order.quantity;
      totalPrice += order.quantity * order.price;
    }

    this.totalPrice.next(totalPrice);
    this.totalNumber.next(totalSize);
  }

  // case 1     cartOrder quantity > 1   2 .......
  // case 2     cartOrder quantity = 1
  decrementOrder(cartOrder: CartOrder){
    cartOrder.quantity--;
    if (cartOrder.quantity === 0) {
      this.removeOrder(cartOrder);
    } else {
      this.calculateTotals();
    }
  }


  removeOrder(cartOrder: CartOrder){
    let index = this.orders.findIndex(order => order.id === cartOrder.id);
    if (index > -1) {
      this.orders.splice(index, 1);
    }
    this.calculateTotals();
  }


}
