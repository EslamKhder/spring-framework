import {Component, OnInit} from '@angular/core';
import {CardService} from "../../../services/card.service";
import {CardOrder} from "../../../model/card-order";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit {

  totalSize: number = 0;
  totalPrice: number = 0;

  constructor(private cardService: CardService) {
  }

  getCardOrderDetails(){
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



}
