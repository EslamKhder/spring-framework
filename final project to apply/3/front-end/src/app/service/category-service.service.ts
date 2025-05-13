import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  categoryUrl = 'http://localhost:9090/Category/getAll';
  constructor(private http: HttpClient) { }


  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.categoryUrl).pipe(
      map(
        response => response
      )
    )
  }

  // getAllCategories(): Observable<Category[]> {
  //
  //   const headers = new HttpHeaders().set('Authorization', `Bearer ` + sessionStorage.getItem("token"));
  //
  //   return this.http.get<Category[]>(this.categoryUrl, {headers}).pipe(
  //     map(response => response)
  //   );
  // }
}
