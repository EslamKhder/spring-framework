import {Component, OnInit} from '@angular/core';
import {CategoryServiceService} from "../../service/category-service.service";
import {Category} from "../../model/category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{

  categories: Category[] = [];
  // @ts-ignore
  constructor(private categoryService: CategoryServiceService) {
  }

  ngOnInit(): void {
    this.getAllCategories()
  }

  getAllCategories(){
    this.categoryService.getAllCategories().subscribe(
      data => {
        this.categories = data;
      }
    )
  }




}
