import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from 'src/app/common/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
 baseUrl ="http://localhost:8080/api/categories";
  constructor(private http:HttpClient) { }
  getCategoies():Observable<Category[]>{
    return this.http.get<Category[]>(this.baseUrl);
  }
}
