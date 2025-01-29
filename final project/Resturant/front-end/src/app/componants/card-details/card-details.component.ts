import {Component, OnInit} from '@angular/core';
import {CartOrderService} from "../../service/cart-order.service";
import {CartOrder} from "../../model/cart-order";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit{


  orders: CartOrder[] = [];
  constructor(private cartOrderService: CartOrderService) {
  }

  ngOnInit(): void {
    this.getCartOrders()
  }

  getCartOrders(){
    this.orders = this.cartOrderService.orders;
  }

  addOrder(order: CartOrder){
    this.cartOrderService.addProductToOrder(order);
  }

  removeOrder(order: CartOrder){
    this.cartOrderService.removeOrder(order);
  }

  removeFullOrder(order: CartOrder){
    this.cartOrderService.remove(order);
  }
}
