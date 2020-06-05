import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Province } from '../province';



@Injectable({
  providedIn: 'root'
})
export class ProvinceService {
private baseUrl:string="http://localhost:8080/api/provinces";
  constructor(private http:HttpClient) {}
  getAllProvinces():Observable<Province[]>{
    return this.http.get<Province[]>(this.baseUrl);
  }
}
