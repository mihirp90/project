import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from '../model/Products';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  getAllProducts():Observable<any> {
    return this.http.get('http://localhost:8080/api/v1/products');
  }

  addNewProduct(product: any): Observable<any>{
    return this.http.post('http://localhost:8080/api/v1/add', product);
  }
}
