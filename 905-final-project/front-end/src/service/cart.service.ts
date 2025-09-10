import { Injectable } from '@angular/core';
import {ProductOrder} from "../model/product-order";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  productOrders: ProductOrder[] = [];//0
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalOrderSize: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  // case 1: productOrders for first one  quantity = 1
  // case 1: productOrders for not first one
  addProductToOrder(product: ProductOrder){

    let isExist: boolean = false;
    let existedProduct: ProductOrder = undefined;

    if(this.productOrders.length > 0){
      existedProduct = this.productOrders.find(productOrder => productOrder.id === product.id);
    }

    isExist = (existedProduct !== undefined);

    if(isExist){
      existedProduct.quantity++;
    } else {
      this.productOrders.push(product)
    }

    this.calculateTotals();
  }

  calculateTotals(){
    let totalElementPrice: number = 0;
    let totalElementSize: number = 0;

    for(let order of this.productOrders){
      totalElementPrice += order.quantity * order.price;
      totalElementSize += order.quantity;
    }

    this.totalPrice.next(totalElementPrice);
    this.totalOrderSize.next(totalElementSize);

    console.log(this.productOrders)
    console.log(this.totalPrice)
    console.log(this.totalOrderSize)
  }

  // case product quantity = 1   0
  // case product quantity = 5   4

  removeProduct(product: ProductOrder){
    product.quantity--;
    if (product.quantity === 0) {
      this.remove(product);
    }

    this.calculateTotals();
  }

  //                 0  1  2  3
  // productOrders [o1,o2,o3,o4]
  remove(product: ProductOrder) {
    let index = this.productOrders.findIndex(productOrder => productOrder.id === product.id); // 0 ....    2
    if(index > -1){
      this.productOrders.splice(index, 1)
    }
  }
}
