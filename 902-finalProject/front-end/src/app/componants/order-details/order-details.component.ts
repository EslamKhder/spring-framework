import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  //details: OrderDetails = null;
  constructor(/* private activatedRoute: ActivatedRoute, private orderService: OrderService*/) { }

  ngOnInit(): void {
    /*debugger
    this.getOrderDetails()*/
  }

/*
  getOrderDetails(){
    debugger
    let codeExist = this.activatedRoute.snapshot.paramMap.has("code");
    if (codeExist) {
      let code = this.activatedRoute.snapshot.paramMap.get("code");
      this.extractOrderDetails(code)
    }
  }

  private extractOrderDetails(code: string) {
    this.orderService.getOrderDetails(code).subscribe(
      value => {
        debugger
        this.details = value;
      }
    )
  }*/
}
