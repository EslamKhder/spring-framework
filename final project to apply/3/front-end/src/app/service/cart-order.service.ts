import { Injectable } from '@angular/core';
import {CartOrder} from "../model/cart-order";
import {BehaviorSubject, Subject} from "rxjs";
import {OrderService} from "./order.service";

@Injectable({
  providedIn: 'root'
})
export class CartOrderService {

  orders: CartOrder[] = [];
  totalOrders: Subject<number> = new BehaviorSubject<number>(0);
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  addProductToOrder(order: CartOrder){
    let isExist: boolean = false;
    let existOrder: CartOrder = undefined;

    if (this.orders.length > 0){
      existOrder = this.orders.find(orderCart => orderCart.id === order.id);
    } //        existOrder undefined        existOrder order

    isExist = (existOrder != undefined);

    if (isExist){
      existOrder.quantity++;
    } else {
      this.orders.push(order);
    }

    console.log(this.orders)

    this.calculateTotals();
  }

  calculateTotals (){
    let totalElementSize: number = 0;
    let totalElementPrice: number = 0;
    for (let temp of this.orders) {
      totalElementSize += temp.quantity;
      totalElementPrice += temp.quantity * temp.price;
    }

    this.totalOrders.next(totalElementSize);
    this.totalPrice.next(totalElementPrice);

    console.log(totalElementSize)
    console.log(totalElementPrice)
  }

  removeOrder(order: CartOrder){ // 2
    order.quantity--;
    if (order.quantity === 0) {
      this.remove(order);
    } else {
      this.calculateTotals();
    }
  }

  remove(order: CartOrder){
    const index = this.orders.findIndex(orderCart => orderCart.id === order.id);
    //   0 1 2 .....           -1
    if (index > -1){
      this.orders.splice(index, 1);
    }
    this.calculateTotals();
  }
}
