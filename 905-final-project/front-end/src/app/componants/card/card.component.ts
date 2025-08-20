import { Component } from '@angular/core';
import {Routes} from "@angular/router";
import {ProductsComponent} from "../products/products.component";
import {CardDetailsComponent} from "../card-details/card-details.component";
import {ContactInfoComponent} from "../contact-info/contact-info.component";
import {ChefsComponent} from "../chefs/chefs.component";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent {
  routes: Routes = [];

}
