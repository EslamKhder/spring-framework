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
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";
import { LoginComponent } from './componants/login/login.component';
import { SignupComponent } from './componants/signup/signup.component';
import {AuthInterceptor} from "./service/intraceptor/auth.interceptor";

// http://localhost:4200/
export const routes: Routes = [

  // http://localhost:4200
  {path: 'category/:id', component: ProductsComponent},
  {path: 'products/:key', component: ProductsComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'cardDetails', component: CardDetailsComponent},
  {path: 'contact-info', component: ContactInfoComponent},
  {path: 'chefs', component: ChefsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  // http://localhost:4200/
  {path: '', redirectTo: '/products', pathMatch: 'full'},

  // if user enter thing without all routes
  {path: '**', redirectTo: '/products', pathMatch: 'full'}

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
    SignupComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbPaginationModule
  ],
  providers: [
    { provide: APP_BASE_HREF, useValue: '/' }
    ,{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor,multi: true},
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {}
