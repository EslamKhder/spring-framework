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
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";

// http://localhost:4200/
export const routes: Routes = [

  // http://localhost:4200/products       ProductsComponent
  // http://localhost:4200/category/:id   ProductsComponent
  // http://localhost:4200/search/:key    ProductsComponent
  {path: 'products', component: ProductsComponent},
  {path: 'cardDetails', component: CardDetailsComponent},
  {path: 'contact-info', component: ContactInfoComponent},
  {path: 'chefs', component: ChefsComponent},
  {path: 'category/:id', component: ProductsComponent},
  {path: 'search/:key', component: ProductsComponent},
  // http://localhost:4200/
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
    ContactInfoComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbPaginationModule
  ],
  providers: [{ provide: APP_BASE_HREF, useValue: '/' }],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
