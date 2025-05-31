import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  baseUrl = 'http://localhost:9091';
  url = 'http://localhost:9091/api/categories/getAll';
  constructor(private http: HttpClient) { }

  getAllCategories(): Observable<Category[]> {
    return this.http
      .get<Category[]>(this.url).pipe(
        map(resp => resp)
    )
  }
}
