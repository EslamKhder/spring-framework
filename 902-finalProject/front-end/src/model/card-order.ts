import {Product} from "./product";

export class CardOrder {
  id: number;
  name: string;
  logoPath: string;
  description: string;
  price: number;
  quantity: number;


  constructor(product: Product) {
    this.id = product.id;
    this.name = product.name;
    this.logoPath = product.logoPath;
    this.description = product.description;
    this.price = product.price;
    this.quantity = 1;
  }
}
