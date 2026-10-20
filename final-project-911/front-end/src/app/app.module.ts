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

// http://localhost:4200/
export const routes: Routes = [

  // http://localhost:4200/active
  {path: 'products', component: ProductsComponent},
  {path: 'cardDetails', component: CardDetailsComponent},
  {path: 'contact-info', component: ContactInfoComponent},
  {path: 'chefs', component: ChefsComponent},
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
    ContactInfoComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule
  ],
  providers: [{ provide: APP_BASE_HREF, useValue: '/' }],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
