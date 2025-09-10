import {Product} from "./product";

export class ProductOrder extends Product{
  quantity: number;

  constructor(product :Product) {
    super();
    this.id = product.id;
    this.name = product.name;
    this.price = product.price;
    this.description = product.description;
    this.imagePath = product.imagePath;
    this.quantity = 1;
  }
}
