import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-order-code',
  templateUrl: './order-code.component.html',
  styleUrls: ['./order-code.component.css']
})
export class OrderCodeComponent implements OnInit {

  code: string = '';
  constructor(private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let codeExist = this.activatedRoute.snapshot.paramMap.has("code");
    if (codeExist) {
      this.code = this.activatedRoute.snapshot.paramMap.get("code");
    } else {
      this.router.navigateByUrl("/products")
    }
  }

}
