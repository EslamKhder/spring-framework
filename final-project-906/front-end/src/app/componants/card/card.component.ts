import {Component, OnInit} from '@angular/core';
import {CardService} from "../../../service/card.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit{

  totalElementSize: number = 0;
  totalElementPrice: number = 0;

  constructor(private cardService: CardService) {
  }

  ngOnInit(): void {
    this.cardService.totalNumber.subscribe(value => {
      this.totalElementSize = value;
    })

    this.cardService.totalPrice.subscribe(value => {
      this.totalElementPrice = value;
    })

  }


}
