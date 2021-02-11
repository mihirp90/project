import { Component, OnInit } from '@angular/core';
import {Products} from '../model/Products';
import { ProductsService } from '../dashboard/products.service';
import { error } from '@angular/compiler/src/util';
import { DynamicDialogRef, DynamicDialogConfig } from 'primeng/dynamicdialog';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  color: string;
  productId: string;
  productName: string;
  price: string;
  brand:string;
  product : Products;

  message : string;
  invalid: boolean;
  constructor(private productsService:ProductsService,
    public ref: DynamicDialogRef, public config: DynamicDialogConfig) { }

  ngOnInit(): void {
    this.invalid = false;
  }

  addProduct(){
    this.product = new Products();
    this.product.productId = this.productId;
    this.product.brand = this.brand;
    this.product.color = this.color;
    this.product.price = this.price;
    this.product.productName = this.productName;

    if(this.product.brand == undefined ||
      this.product.color == undefined ||
      this.product.brand == undefined ||
      this.product.productName == undefined ||
      this.product.productId == undefined){
        this.invalid = true;
        this.message = "All fields require";
    }else{
      this.invalid = false;
    }
    if(!this.invalid){
      this.productsService.addNewProduct(this.product)
          .subscribe(
            data =>{
              console.log("Product Added successfully");
              this.ref.close();
            },
            error => {
              console.log("error", error);
            }
        )
    }
  }

  validite(){
    
  }

}
