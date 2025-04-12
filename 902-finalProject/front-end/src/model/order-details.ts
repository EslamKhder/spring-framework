import {Product} from "./product";

export class OrderDetails {
  userName: string;
  email: string;
  code: string;
  totalPrice: string;
  totalQuantity: string;
  products: Product[];
}
