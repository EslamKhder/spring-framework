import {Component, OnInit} from '@angular/core';
import {CardOrder} from "../../../model/card-order";
import {CardService} from "../../../service/card.service";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent  implements OnInit{

  orders: CardOrder[] = [];

  constructor(private cardService: CardService) {
  }
  ngOnInit(): void {
    this.orders = this.cardService.orders;
  }

  addOrder(order: CardOrder){
    this.cardService.addProductTOrder(order)
  }

  decreaseOrder(order: CardOrder){
    this.cardService.removeOrder(order)
  }

  removeFullOrder(order: CardOrder){
    this.cardService.remove(order)
  }
}
