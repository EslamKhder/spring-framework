import {Product} from "./product";

export class CartOrder {
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
    this.price = product.price;
    this.description = product.description;
    this.quantity = 1;
  }
}
