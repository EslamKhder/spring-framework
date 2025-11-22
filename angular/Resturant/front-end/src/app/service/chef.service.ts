import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {map} from "rxjs/operators";
import {Chefs} from "../model/chefs";

@Injectable({
  providedIn: 'root'
})
export class ChefService {

  chefUrl = 'http://localhost:9090/Chefs/getAll';
  constructor(private http: HttpClient) { }


  getAllChefs(): Observable<Chefs[]> {
    return this.http.get<Chefs[]>(this.chefUrl).pipe(
      map(
        response => response
      )
    )
  }
}
