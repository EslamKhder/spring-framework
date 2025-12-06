import {Component, OnInit} from '@angular/core';
import {CartService} from "../../../service/cart.service";
import {Item} from "../../../model/item";
import {Product} from "../../../model/product";
import {OrderService} from "../../../service/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent  implements OnInit {
  items: Item[] = [];

  constructor(private cartService: CartService, private orderService: OrderService, private router: Router) {

  }

  ngOnInit(): void {
    this.items = this.cartService.items;
  }

  addProduct(item: Item){
    this.cartService.addItem(item);
  }
  decrementItem(item: Item){
    this.cartService.decrementItem(item);
  }
  removeItem(item: Item){
    this.cartService.removeItem(item);
  }

  takeOrder(){
    debugger
    const requestOrder = this.cartService.items.map(item => ({
      id: item.id,
      quantity: item.quantity
    }));

    this.orderService.takeOrder(requestOrder).subscribe(
      response => {
        this.router.navigateByUrl('order/code/' + response.code + '/size/' + response.totalNumber + '/price/' + response.totalPrice);
        this.cartService.items = [];
        this.cartService.totalPrice.next(0)
        this.cartService.totalSize.next(0)
      }
    )
  }

}
