import {Component, OnInit} from '@angular/core';
import {Routes} from "@angular/router";
import {ProductsComponent} from "../products/products.component";
import {CardDetailsComponent} from "../card-details/card-details.component";
import {ContactInfoComponent} from "../contact-info/contact-info.component";
import {ChefsComponent} from "../chefs/chefs.component";
import {CartService} from "../../../service/cart.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit {
  totalProductSize: number = 0;
  totalProductPrice: number = 0;

  ngOnInit(): void {
    this.getTotals()
  }

  constructor(private cartService: CartService) {
  }

  getTotals(){
    this.cartService.totalOrderSize.subscribe(
      value => this.totalProductSize = value
    )
    this.cartService.totalPrice.subscribe(
      value => this.totalProductPrice = value
    )
  }



}
