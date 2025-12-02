import {Component, OnInit} from '@angular/core';
import {CartService} from "../../../service/cart.service";
import {CartOrder} from "../../../model/cart-order";
import {OrderService} from "../../../service/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {

  orders: CartOrder[] = [];
  // totalPrice: number = 0;
  // totalNumber: number = 0;

  ngOnInit(): void {
    this.getOrderDetails();
  }

  constructor(private cartService: CartService,private orderService: OrderService, private router: Router) {
  }

  getOrderDetails(){
    this.orders = this.cartService.orders;



    // this.cartService.totalPrice.subscribe(
    //   value => this.totalPrice = value
    // );
    //
    // this.cartService.totalNumber.subscribe(
    //   value => this.totalNumber = value
    // );
  }


  addOrder(cartOrder: CartOrder){
    this.cartService.addOrder(cartOrder);
  }

  decrementOrder(cartOrder: CartOrder){
    this.cartService.decrementOrder(cartOrder);
  }

  removeOrder(cartOrder: CartOrder){
    this.cartService.removeOrder(cartOrder);
  }

  createOrder(){
    let requestOrder = this.cartService.orders.map(order => ({
      id: order.id,
      quantity: order.quantity
    }));

    this.orderService.createOrder(requestOrder).subscribe(
      response => {
        this.cartService.orders = [];
        this.cartService.totalPrice.next(0);
        this.cartService.totalNumber.next(0);
        this.router.navigateByUrl("order-res/code/" + response.code + "/size/" + response.totalNumber+ "/price/"+ + response.totalPrice)
      }
    )

  }

}
