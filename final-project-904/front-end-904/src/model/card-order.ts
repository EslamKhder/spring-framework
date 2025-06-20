import {Product} from "./product";

export class CardOrder {

  id: number;
  name: string;
  description: string;
  price: number;
  imagePath: string;
  quantity: number;

  constructor(product: Product) {
    this.id = product.id;
    this.name = product.name;
    this.description = product.description;
    this.price = product.price;
    this.imagePath = product.imagePath;
    this.quantity = 1;
  }
}
