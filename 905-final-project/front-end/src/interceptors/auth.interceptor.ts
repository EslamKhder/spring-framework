import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from "../service/auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // api  login  signup
    debugger
    if (this.authService.isUserLogin()){
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + sessionStorage.getItem("token")
        }
      })
    }

    return next.handle(request);
  }
}
