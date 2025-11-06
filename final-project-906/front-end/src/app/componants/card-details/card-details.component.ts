import {Component, OnInit} from '@angular/core';
import {CardService} from "../../../service/card.service";
import {CardItem} from "../../../model/card-item";

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {

  totalElementSize: number = 0;
  totalElementPrice: number = 0;
  items: CardItem[] = [];

  constructor(private cardService: CardService) {
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
}
