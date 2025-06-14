import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {UserService} from "../security/user.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private userService: UserService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(this.userService.isUserLogin()){
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + sessionStorage.getItem("token")
        }
      });
    }
    return next.handle(request);
  }
}
