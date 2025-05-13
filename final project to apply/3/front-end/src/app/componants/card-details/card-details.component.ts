import {Component, OnInit} from '@angular/core';
import {CartOrderService} from "../../service/cart-order.service";
import {CartOrder} from "../../model/cart-order";
import {OrderService} from "../../service/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit{

  totalQuantity: number = 0;
  totalPrice: number = 0;
  orders: CartOrder[] = [];
  constructor(private cartOrderService: CartOrderService, private orderService: OrderService,
              private route: Router) {
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

  saveOrder() {
    const productsIds: number [] = this.cartOrderService.orders.map(product => product.id);

    this.cartOrderService.totalOrders.subscribe(
      data => {
        this.totalQuantity = data
      }
    )
    this.cartOrderService.totalPrice.subscribe(
      data => {
        this.totalPrice = data
      }
    )

    this.orderService.createOrder(this.totalQuantity, this.totalPrice, productsIds).subscribe(
      data => {
        alert("your code to recieve Order is :" + data.code);
        this.cartOrderService.orders = [];
        this.cartOrderService.totalOrders.next(0);
        this.cartOrderService.totalPrice.next(0);
        this.orders = [];
        this.route.navigateByUrl("/products");
      }
    );
  }
}
