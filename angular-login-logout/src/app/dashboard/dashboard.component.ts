import { Component, OnInit, OnDestroy } from '@angular/core';
import {Products} from '../model/Products';
import { ProductsService } from './products.service';
import {DialogService} from 'primeng/dynamicdialog';
import {DynamicDialogRef} from 'primeng/dynamicdialog';
import { AddProductComponent } from '../add-product/add-product.component';
import { Table } from 'primeng/table/table';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  providers:[DialogService]
})
export class DashboardComponent implements OnInit, OnDestroy {

  products : Products[];
  ref: DynamicDialogRef;

  constructor(private productService: ProductsService, public dialogService: DialogService) { }

  ngOnInit() {
    this.productService.getAllProducts()
        .subscribe(
          data=>{
            this.products = data;
          }
        )
  }

  handleClick(event) {
    //execute action
     this.ref = this.dialogService.open(AddProductComponent, {
      header: 'Adding New Product',
      width: '80%',
      contentStyle: {"max-height": "500px", "overflow": "auto"},
      baseZIndex: 10000
    });

    this.ref.onClose.subscribe(() =>{  
      this.productService.getAllProducts()
        .subscribe(
          data=>{
            this.products = data;
          }
        )
    });
  }

  ngOnDestroy() {
    if (this.ref) {
        this.ref.close();
    }
  }
  clear(table: Table) {
    table.clear();
  }

}
