import {Component, OnInit} from '@angular/core';
import {CartService} from "../../../service/cart.service";
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit {

  totalSize: number;
  totalPrice: number;

  constructor(private cartService: CartService) {

  }

  ngOnInit(): void {
    this.cartService.totalSize.subscribe(
      value => this.totalSize = value
    )

    this.cartService.totalPrice.subscribe(
      value => this.totalPrice = value
    )

  }

}
