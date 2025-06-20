import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from "../security/auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // token  login
    // case 1: api to login /login
    // case 2 : api to get products   /product
    if (this.authService.isUserLogin()) {
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + sessionStorage.getItem("token")
        }
      })
    }

    return next.handle(request);
  }
}
