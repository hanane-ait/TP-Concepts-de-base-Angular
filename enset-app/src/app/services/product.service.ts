import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http : HttpClient) { }

  getAllProdutcs(){
    return this.http.get("http://localhost:8084/products");
  }
  deleteProducts(product : any){
    return this.http.delete("http://localhost:8084/products/"+ product.id);
  }
}
