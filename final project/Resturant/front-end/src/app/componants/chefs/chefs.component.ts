import { Component, OnInit } from '@angular/core';
import {Chefs} from "../../model/chefs";
import {ChefService} from "../../service/chef.service";

@Component({
  selector: 'app-chefs',
  templateUrl: './chefs.component.html',
  styleUrls: ['./chefs.component.css']
})
export class ChefsComponent implements OnInit {

  chefs: Chefs[] = [];

  constructor(private chefsService: ChefService) {
  }

  ngOnInit(): void {
    this.getAllChefs()
  }

  getAllChefs(){
    this.chefsService.getAllChefs().subscribe(
      data => {
        this.chefs = data;
      }
    )
  }



}
