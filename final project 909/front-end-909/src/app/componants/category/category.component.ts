import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../service/category.service";
import {Category} from "../../../model/category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: Category[] = [];
  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.getCategories();
  }


  getCategories(): void {
    this.categoryService.getAllCategories().subscribe(
      response => this.categories = response
    )
  }
}
