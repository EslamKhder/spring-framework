import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../service/category.service";
import {Category} from "../../../model/category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{

  categories: Category[] = [];

  ngOnInit(): void {
    this.getCategories();
  }

  constructor(private categoryService: CategoryService) {
  }



  getCategories(){
    this.categoryService.getAllCategories().subscribe(
      value => this.categories = value
    );
  }


}
