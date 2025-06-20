import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {NgModule} from '@angular/core';
import {ProductsComponent} from './componants/products/products.component';
import {HeaderComponent} from './componants/header/header.component';
import {CategoryComponent} from './componants/category/category.component';
import {CardDetailsComponent} from './componants/card-details/card-details.component';
import {CardComponent} from './componants/card/card.component';
import {BrowserModule} from '@angular/platform-browser';
import {FooterComponent} from './componants/footer/footer.component';
import { ChefsComponent } from './componants/chefs/chefs.component';
import { ContactInfoComponent } from './componants/contact-info/contact-info.component';
import {APP_BASE_HREF} from '@angular/common';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";
import { LoginComponent } from './componants/login/login.component';
import { SignupComponent } from './componants/signup/signup.component';
import {AuthInterceptor} from "../services/interceptor/auth.interceptor";
import {AuthGuard} from "../services/guard/auth.guard";
import {SignupLoginGuard} from "../services/guard/signup-login.guard";
import { OrderCodeComponent } from './componants/order-code/order-code.component';

// http://localhost:4200/
export const routes: Routes = [

  // http://localhost:4200/products       ProductsComponent
  // http://localhost:4200/category/:id   ProductsComponent
  // http://localhost:4200/search/:key    ProductsComponent
  {path: 'products', component: ProductsComponent, canActivate: [AuthGuard]},
  {path: 'cardDetails', component: CardDetailsComponent, canActivate: [AuthGuard]},
  {path: 'contact-info', component: ContactInfoComponent, canActivate: [AuthGuard]},
  {path: 'chefs', component: ChefsComponent, canActivate: [AuthGuard]},
  {path: 'category/:id', component: ProductsComponent, canActivate: [AuthGuard]},
  {path: 'search/:key', component: ProductsComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent, canActivate: [SignupLoginGuard]},
  {path: 'signup', component: SignupComponent, canActivate: [SignupLoginGuard]},
  {path: 'order-code/:code', component: OrderCodeComponent, canActivate: [AuthGuard]},
  // http://localhost:4200/
  {path: '**', redirectTo: '/products', pathMatch: 'full'},
  {path: '', redirectTo: '/products', pathMatch: 'full'},

  //z '/products', pathMatch: 'full'}

];

/*
*   // http://localhost:4200/
  {path: '', component:OrderItemsComponent}
* */
@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    HeaderComponent,
    CategoryComponent,
    CardDetailsComponent,
    CardComponent,
    FooterComponent,
    ChefsComponent,
    ContactInfoComponent,
    LoginComponent,
    SignupComponent,
    OrderCodeComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbPaginationModule
  ],
  providers: [
    { provide: APP_BASE_HREF, useValue: '/' },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
