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


  getCategories(): void {
    this.categoryService.getAllCategories().subscribe(
      response => this.categories = response
    );
  }



}
