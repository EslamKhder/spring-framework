import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-ordercode',
  templateUrl: './ordercode.component.html',
  styleUrls: ['./ordercode.component.css']
})
export class OrdercodeComponent implements OnInit {

  code: string = "";
  totalElement: string = "";
  totalPrice: string = "";
  constructor(private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let isHasCode = this.activatedRoute.snapshot.paramMap.has("code");
    let isHasTotalElement = this.activatedRoute.snapshot.paramMap.has("totalNumber");
    let isHasTotalPrice = this.activatedRoute.snapshot.paramMap.has("totalPrice");

    if (isHasCode && isHasTotalElement && isHasTotalPrice) {
      this.code = this.activatedRoute.snapshot.paramMap.get("code");
      this.totalElement = this.activatedRoute.snapshot.paramMap.get("totalNumber");
      this.totalPrice = this.activatedRoute.snapshot.paramMap.get("totalPrice");
      return;
    }


    this.router.navigateByUrl("/products");

  }

}
