import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../service/category.service";
import {Category} from "../../../model/category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: Category[] = []; // 50
  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {

    this.categoryService.getCategories().subscribe(
      response => this.categories = response
    );

  }

}
