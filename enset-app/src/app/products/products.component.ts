import {Component, OnInit} from '@angular/core';
import {NgIf} from "@angular/common";
import {ProductService} from "../services/product.service";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit {
  products: any ;
  constructor(private productService: ProductService) {
  }
  ngOnInit() {
    this.getAllProdutcs();
  }
  getAllProdutcs(): void {
     this.productService.getAllProdutcs().subscribe({
       next : resp=> {
         this.products=resp;
       },
       error : err =>{
         console.log(err);
       }
     })
  }

  protected handlDelete(product: any) {
    let v = confirm('etes vous sure de vouloir supprimer?')
    if (v==true){
      this.productService.deleteProducts(product).subscribe({
        next : value => {
          this.getAllProdutcs();
        },
        error : err =>{
          console.log(err);
        }
      })

    }

  }
}
