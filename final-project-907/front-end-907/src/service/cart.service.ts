import { Injectable } from '@angular/core';
import {Item} from "../model/item";
import {BehaviorSubject, Subject} from "rxjs";

// case 1: items empty and you need to add item
// case 2: items not empty item not exist and you add new one
// case 3: items not empty item exist and you add new one
/*
items []    add item           direct add with quantity 1
items [t1, t2] add item t3     direct add with quantity 1
items [t1, t2,t3] add item t3  quantity++
 */

@Injectable({
  providedIn: 'root'
})
export class CartService {


  items: Item[] = [];//t1,t2,t3
  totalSize: Subject<number> = new BehaviorSubject(0);
  totalPrice: Subject<number> = new BehaviorSubject(0);

  constructor() { }

  addItem(newItem: Item){
    let isExist: boolean = false;
    let existItem: Item = undefined;

    if (this.items.length > 0) {
      existItem = this.items.find(item => item.id === newItem.id);
    }

    isExist = (existItem !== undefined);

    if (isExist) {
      existItem.quantity++;
    } else {
      this.items.push(newItem)
    }

    this.calculateTotals();
    console.log(JSON.stringify(this.items))
    console.log(this.totalSize)
    console.log(this.totalPrice)
  }


  calculateTotals(){
    let totalElementSize = 0;
    let totalElementPrice = 0;

    for (let it of this.items) {
      totalElementSize += it.quantity;
      totalElementPrice += it.quantity * it.price;
    }

    this.totalSize.next(totalElementSize);
    this.totalPrice.next(totalElementPrice);

  }

  decrementItem(removedItem: Item){
    removedItem.quantity--;
    if (removedItem.quantity === 0) {
      this.removeItem(removedItem);
    } else {
      this.calculateTotals();
    }
  }

  //        0    2   3
  // items [t1,t3, t4]
  removeItem(removedItem: Item){ // t2
    let index = this.items.findIndex(item=> item.id === removedItem.id); // 1
    if (index > -1) {
      this.items.splice(index, 1);
    }
    this.calculateTotals();
  }


}
