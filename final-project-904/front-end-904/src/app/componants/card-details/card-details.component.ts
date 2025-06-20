import {Component, OnInit} from '@angular/core';
import {CardService} from "../../../services/card.service";
import {CardOrder} from "../../../model/card-order";
import {Product} from "../../../model/product";
import {CardRequestService} from "../../../services/card-request.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit{

  orders: CardOrder[] = [];
  totalSize: number = 0;
  totalPrice: number = 0;

  constructor(private cardService: CardService, private cardRequestService: CardRequestService, private router: Router) {
  }

  getCardOrderDetails(){
    this.orders = this.cardService.orders;
    this.cardService.totalSize.subscribe(
      value => this.totalSize = value
    );

    this.cardService.totalPrice.subscribe(
      value => this.totalPrice = value
    );
  }

  ngOnInit(): void {
    this.getCardOrderDetails()
  }


  addOrder(order: CardOrder){
    this.cardService.addProductToOrder(order)
  }

  removeFullOrder(order: CardOrder){
    this.cardService.removeOrder(order)
  }

  decrementOrder(order: CardOrder){
    this.cardService.decrementOrder(order)
  }

  createOrder(){
    const productIds = this.orders.map(or => or.id);
    this.cardRequestService.createOrder(productIds, this.totalPrice, this.totalSize).subscribe(
      response => {
        this.cardService.orders = [];
        this.cardService.totalSize.next(0);
        this.cardService.totalPrice.next(0);
        this.router.navigateByUrl("/order-code/" + response.code)
      }
    )
  }

}
