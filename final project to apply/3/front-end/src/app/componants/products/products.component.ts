import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute} from "@angular/router";
import {CartOrderService} from "../../service/cart-order.service";
import {CartOrder} from "../../model/cart-order";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products: Product[] = [];
  messageResultEn: string = "";
  messageResultAr: string = "";
  productSize: number = 0;
  // pageNumber refere to  page you need to return
  pageNumber: number = 1;
  // pageSize refere to  size of product on page
  pageSize: number = 10;
  // productsCollection refere to  size product
  productsCollection: number = 0;

  constructor(private productService: ProductService,
              private activatedRoute:ActivatedRoute,
              private cartOrderService: CartOrderService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      () => {
        this.finalProducts();
      }
    )
  }

  finalProducts(){
    let idCategoryExist = this.activatedRoute.snapshot.paramMap.has('id');
    let keyExist = this.activatedRoute.snapshot.paramMap.has('key');
    if (idCategoryExist) {
      let idCategory = this.activatedRoute.snapshot.paramMap.get('id');
      this.getProductsByCategoryId(idCategory);
    } else if (keyExist) {
      let key = this.activatedRoute.snapshot.paramMap.get('key');
      this.getProductsByKey(key)
    } else {
      this.getAllProducts();
    }
  }

  getAllProducts(){

    this.productService.getProductSize().subscribe(
      data => {
        debugger
        this.productsCollection = data;
        this.productSize = data
      }
    )
    this.productService.getAllProduct(this.pageNumber-1, this.pageSize).subscribe(
      data => {
        debugger
        this.products = data;
      }
    )
  }

  getProductsByCategoryId(categoryId){
    this.productService.getProductSizeByCategoryId(categoryId).subscribe(
      data => {
        this.productsCollection = data;
        this.productSize = data
      }
    )
    this.productService.getProductById(categoryId, this.pageNumber-1, this.pageSize).subscribe(
      data => {
        this.products = data;
        if (this.products.length === 0) {
          this.productSize = -2;
        }
      }
    )
  }


  getProductsByKey(key){
    this.productService.getProductSizeByKey(key).subscribe(
      data => {
        this.productsCollection = data;
        this.productSize = data;
      }
    )
    this.productService.getProductByKey(key, this.pageNumber-1, this.pageSize).subscribe(
      data => {
        // @ts-ignore
        if (data && 'status' in data && data.status === 'BAD_REQUEST') {

          // @ts-ignore
          this.messageResultEn = data.bundleMessage.message_en;

          // @ts-ignore
          this.messageResultAr = data.bundleMessage.message_ar;
          this.products = [];
          this.productSize = -1;
        } else {
          this.products = data;
        }

      }
    )
  }

  doPagination(){
    this.finalProducts();
  }

  changePageSize(event: Event){
    this.pageSize = +(<HTMLInputElement>event.target).value;
    this.finalProducts();
  }

  addProduct(product: Product){
    const orderCart = new CartOrder(product);
    this.cartOrderService.addProductToOrder(orderCart);
  }
}

