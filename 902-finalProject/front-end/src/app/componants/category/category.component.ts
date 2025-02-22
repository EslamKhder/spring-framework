import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{
  category: Category[] = [];
  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.loadAllProduct()
  }

  loadAllProduct(){
    this.categoryService.getAllCategory().subscribe(
      response => {
        this.category = response
      }
    )
  }
}
