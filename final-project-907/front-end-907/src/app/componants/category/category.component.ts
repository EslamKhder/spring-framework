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
      this.getAllCategories();
  }


  getAllCategories(){
    this.categoryService.getCategories().subscribe(
      result => this.categories = result
    );
  }
}
