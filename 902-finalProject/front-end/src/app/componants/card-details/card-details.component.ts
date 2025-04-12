import {Component, OnInit} from '@angular/core';
import {CartService} from "../../../service/cart.service";
import {CardOrder} from "../../../model/card-order";
import {OrderService} from "../../../service/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {

  order: CardOrder[] = [];
  totalPrice: number = 0;
  totalQuantity: number = 0;
  constructor(private cartService: CartService, private orderService: OrderService, private router: Router) {
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

  createOrder(){

    const productsIds = this.cartService.order.map(order => order.id);

    this.cartService.totalOrdersPrice.subscribe(
      value => this.totalPrice = value
    )

    this.cartService.totalOrdersSize.subscribe(
      value => this.totalQuantity = value
    )

    this.orderService.createOrder(this.totalPrice, this.totalQuantity, productsIds).subscribe(
      value => {
        //alert("your code is " + value.code);
        this.cartService.order = [];
        this.cartService.totalOrdersSize.next(0);
        this.cartService.totalOrdersPrice.next(0);
        this.router.navigateByUrl("/orderDetails/" + value.code);
      },
      error => {
        // Error handling
        console.error("Error occurred while placing the order:", error);
        alert("Failed to place order. Please try again later.");
      }
    )
  }

}
