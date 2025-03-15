import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "../auth/auth.service";

@Injectable({
  providedIn: 'root',
})

export class ScreenActivator implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  // if not login can go to login com and sigun com
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    if (this.authService.isUserLogIn()) {
      return true;
    }

    this.router.navigateByUrl("/login");
    return false;
  }

}
