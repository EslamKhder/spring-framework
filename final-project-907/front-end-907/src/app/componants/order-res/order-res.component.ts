import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-order-res',
  templateUrl: './order-res.component.html',
  styleUrls: ['./order-res.component.css']
})
export class OrderResComponent implements OnInit {

  code: string = '';
  totalPrice: string = '';
  totalNumber: string = '';

  constructor(private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let codeExist = this.activatedRoute.snapshot.paramMap.has("code");
    let sizeExist = this.activatedRoute.snapshot.paramMap.has("size");
    let priceExist = this.activatedRoute.snapshot.paramMap.has("price");

    if (!codeExist || !sizeExist || !priceExist) {
      this.router.navigateByUrl("/products");
    }

    this.code = this.activatedRoute.snapshot.paramMap.get("code");
    this.totalNumber = this.activatedRoute.snapshot.paramMap.get("size");
    this.totalPrice = this.activatedRoute.snapshot.paramMap.get("price");

  }

}
