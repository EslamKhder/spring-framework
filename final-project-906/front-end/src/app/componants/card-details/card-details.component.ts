import {Component, OnInit} from '@angular/core';
import {CardService} from "../../../service/card.service";
import {CardItem} from "../../../model/card-item";
import {OrderService} from "../../../service/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {

  totalElementSize: number = 0;
  totalElementPrice: number = 0;
  items: CardItem[] = [];

  constructor(private cardService: CardService, private orderService: OrderService, private router: Router) {
  }

  ngOnInit(): void {
    this.cardService.totalNumber.subscribe(value => {
      this.totalElementSize = value;
    })

    this.cardService.totalPrice.subscribe(value => {
      this.totalElementPrice = value;
    })
    this.items = this.cardService.cardItems;
  }

  addItem(item: CardItem) {
    this.cardService.addProduct(item)
  }

  removeItem(item: CardItem) {
    this.cardService.removeItem(item)
  }

  remove(item: CardItem) {
    this.cardService.remove(item)
  }

  takeOrder() {
    const requestOrderVm = this.cardService.cardItems.map(item => ({
      id: item.id,
      quantity: item.quantity
    }));

    this.orderService.createOrder(requestOrderVm).subscribe(
      response => {
        this.router.navigateByUrl("order-code/" + response.code + "/totalPrice/" + response.totalPrice + "/totalNumber/" + response.totalNumber);
        this.cardService.cardItems = [];
        this.cardService.totalNumber.next(0);
        this.cardService.totalPrice.next(0);
      }
    )
  }
}
