import { Component, OnInit } from '@angular/core';
import {RequestOrderService} from "../../../service/request-order.service";

@Component({
  selector: 'app-order-user',
  templateUrl: './order-user.component.html',
  styleUrls: ['./order-user.component.css']
})
export class OrderUserComponent implements OnInit {

  orders: any;
  constructor(private requestOrderService : RequestOrderService) { }

  ngOnInit(): void {
    this.requestOrderService.getOrder().subscribe(
      value => this.orders = value
    )
  }


}
