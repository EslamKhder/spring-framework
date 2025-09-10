import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  categoryUrl = 'http://localhost:9090/categories/all-categories';
  constructor(private http: HttpClient) {

  }

  getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.categoryUrl).pipe(
      map(
        response => response
      )
    )
  }
}
