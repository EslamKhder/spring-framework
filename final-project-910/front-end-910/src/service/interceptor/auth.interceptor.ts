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

    if (!this.authService.isUserLogin()) {
      return next.handle(request);
    }

    const token = sessionStorage.getItem("token");

    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + token
        }
      })
    }

    return next.handle(request);
  }
}
