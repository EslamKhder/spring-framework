import { Component, OnInit } from '@angular/core';
import {OrderService} from "../../../service/order.service";
import {ActivatedRoute, Router} from "@angular/router";
import {OrderDetails} from "../../../model/order-details";
@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  details: OrderDetails = null;
  allOrderDetails: OrderDetails[] =[];
  constructor(private activatedRoute: ActivatedRoute, private orderService: OrderService, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => this.orderDetails()
    )

  }


  orderDetails(){
    let codeExist = this.activatedRoute.snapshot.paramMap.has("code");
    if (codeExist)  {
      let code = this.activatedRoute.snapshot.paramMap.get("code");
      if (code === 'user') {
        this.orderService.getRequestOrdersRelatedToUser().subscribe(
          value => {
            this.allOrderDetails = value;
          }
        )
      } else if (code == 'allUser') {
        this.orderService.getAllRequestOrders().subscribe(
          value => {
            this.allOrderDetails = value;
          }
        )
      } else if (code) {
        this.orderService.getOrderDetails(code).subscribe(
          value => {
            this.details = new OrderDetails();
            this.details = value;
          }
        )
      }
    } else {
      this.router.navigateByUrl("/products")
    }
  }
  // getOrderDetails(){
  //   debugger
  //   let codeExist = this.activatedRoute.snapshot.paramMap.has("code");
  //   if (codeExist) {
  //     let code = this.activatedRoute.snapshot.paramMap.get("code");
  //     this.extractOrderDetails(code)
  //   }
  // }
  //
  // private extractOrderDetails(code: string) {
  //   this.orderService.getOrderDetails(code).subscribe(
  //     value => {
  //       debugger
  //       this.details = value;
  //     }
  //   )
  // }
}
