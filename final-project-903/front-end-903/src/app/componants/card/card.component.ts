import {Component, OnInit} from '@angular/core';
import {CardService} from "../../../service/card.service";
import {CardOrder} from "../../../model/card-order";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit{

  totalPrice: number = 0;
  totalOrdersSize: number = 0;

  constructor(private cardService: CardService) {
  }
  ngOnInit(): void {
    this.cardService.totalPrice.subscribe(
      value => this.totalPrice = value
    )

    this.cardService.totalOrdersSize.subscribe(
      value => this.totalOrdersSize = value
    )
  }


}
