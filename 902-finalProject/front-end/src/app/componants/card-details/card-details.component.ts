import {Component, OnInit} from '@angular/core';
import {CartService} from "../../../service/cart.service";
import {CardOrder} from "../../../model/card-order";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {

  order: CardOrder[] = [];

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    this.getOrders()
  }


  getOrders(){
    this.order = this.cartService.order;
  }


  increaseOrder(order: CardOrder) {
    this.cartService.addProductToOrder(order)
  }

  deCreaseOrder(order: CardOrder) {
    this.cartService.deCreaseOrder(order)
  }


  removeOrder(order: CardOrder){
    this.cartService.removeOrder(order)
  }

}
