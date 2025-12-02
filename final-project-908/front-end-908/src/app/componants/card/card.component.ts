import {Component, OnInit} from '@angular/core';
import {Routes} from "@angular/router";
import {CartService} from "../../../service/cart.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit {

  totalPrice: number = 0;
  totalNumber: number = 0;

  ngOnInit(): void {
    this.getTotals();
  }

  constructor(private cartService: CartService) {
  }

  getTotals(){
    this.cartService.totalPrice.subscribe(
      value => this.totalPrice = value
    );

    this.cartService.totalNumber.subscribe(
      value => this.totalNumber = value
    );
  }


}
