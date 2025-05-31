import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: Category[] = [];

  ngOnInit(): void {
    this.getAllCategories();
  }

  constructor(private categoryService: CategoryService) { }

  getAllCategories() {
    this.categoryService.getAllCategories().subscribe(
      response => {
        this.categories = response;
      }
    )
  }

}
