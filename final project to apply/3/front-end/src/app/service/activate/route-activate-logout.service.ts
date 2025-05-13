import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {AuthService} from "../security/auth.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RouteActivateLogoutService implements CanActivate{

  constructor(private authService: AuthService, private route: Router) {
  }



  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authService.isUserLogin()) {
      this.route.navigateByUrl("/products");
      return false;
    }
    return true;
  }
}
