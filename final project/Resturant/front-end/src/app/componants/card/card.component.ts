import {Component, OnInit} from '@angular/core';
import {CartOrderService} from "../../service/cart-order.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit{

  totalOrdersSize: number = 0;
  totalOrdersPrice: number = 0;
  constructor(private cartOrderService: CartOrderService) {
  }

  ngOnInit(): void {
    this.getCartStatus()
  }

  getCartStatus(){
    this.cartOrderService.totalOrders.subscribe(
      data => {
        this.totalOrdersSize = data;
      }
    )

    this.cartOrderService.totalPrice.subscribe(
      data => {
        this.totalOrdersPrice = data;
      }
    )
  }
}
