import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-order-code',
  templateUrl: './order-code.component.html',
  styleUrls: ['./order-code.component.css']
})
export class OrderCodeComponent implements OnInit {

  code: string = "";

  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let hasCode = this.activatedRoute.snapshot.paramMap.has("code");
    if (hasCode){
      let code = this.activatedRoute.snapshot.paramMap.get("code");
      this.code = code;
    }  else {
      this.code = "no code found pls create order";
    }
  }

}
