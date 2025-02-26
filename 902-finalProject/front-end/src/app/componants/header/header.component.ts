import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  category: Category[] = [];
  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.loadAllCategory()
  }

  loadAllCategory(){
    this.categoryService.getAllCategory().subscribe(
      response => {
        this.category = response
      }
    )
  }


  search(keySearch){
    this.router.navigateByUrl("/search/" + keySearch) // rice
  }

}
