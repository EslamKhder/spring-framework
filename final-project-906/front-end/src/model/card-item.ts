import {Product} from "./product";

export class CardItem {
  id: number;
  name: string;
  description: string;
  price: number;
  image: string;
  quantity: number;

  constructor(product: Product) {
    this.id = product.id;
    this.name = product.name;
    this.description = product.description;
    this.price = product.price;
    this.image = product.image;
    this.quantity = 1;
  }

}
