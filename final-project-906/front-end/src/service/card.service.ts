import { Injectable } from '@angular/core';
import {CardItem} from "../model/card-item";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CardService {

  cardItems: CardItem [] = [];
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalNumber: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  // =
  // ==
  // ===

  // case   empty
  // case   not empty  not included cardItem
  // case   not empty  included cardItem
  addProduct(cardItem: CardItem){
    let isExist: boolean = false;
    let itemExist: CardItem = undefined;

    if (this.cardItems.length > 0){
      itemExist = this.cardItems.find(item => item.id === cardItem.id); // 1 == 1   "1" == 1
    }

    isExist = (itemExist !== undefined);
    if (isExist){
      itemExist.quantity++;
    } else {
      this.cardItems.push(cardItem)
    }

    console.log("items ===> " + JSON.stringify(this.cardItems));


    this.calculateTotals();

    console.log(this.totalNumber)
    console.log(this.totalPrice)
  }

  calculateTotals(){
    let price: number = 0;
    let size: number = 0;
    for (let item of this.cardItems) {
      price += item.price * item.quantity;
      size += item.quantity;
    }

    this.totalNumber.next(size);
    this.totalPrice.next(price);
  }

  // case cardItem    quantity > 1
  // case cardItem    quantity = 1   ---> 0
  removeItem(cardItem: CardItem){
    cardItem.quantity--;

    if(cardItem.quantity === 0){
      this.remove(cardItem)
    } else {
      this.calculateTotals()
    }
  }


  remove(cardItem: CardItem){ // q = 50
    let index = this.cardItems.findIndex(item => item.id === cardItem.id); // 0 1 2 .....    /// -1

    if (index > -1) {
      //  0  1  2  3  4
      // [o1,o2,o3,o4,o5]
      this.cardItems.splice(index, 1);
    }
    this.calculateTotals()
  }




}
