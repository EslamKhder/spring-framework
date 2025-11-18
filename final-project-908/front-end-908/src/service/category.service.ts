import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  baseUrl = "http://localhost:9090/api/categories";
  constructor(private http: HttpClient) { }


  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.baseUrl + "/getAll").pipe(
      map(
        response => response
      )
    );
  }




}
