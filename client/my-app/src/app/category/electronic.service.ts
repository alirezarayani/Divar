import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ElectronicDevice } from 'src/app/common/electronic-device';
import { map } from 'rxjs/operators';
import { PageClient } from '../common/PageClient';

@Injectable({
  providedIn: 'root'
})
export class ElectronicService {
private baseUrl="http://localhost:8080/api/electronic-devices";
  constructor(private http:HttpClient) { }

  // getElectronicDevices(page:number):Observable<PageClient>{
  //   return this.http.get<PageClient>(this.baseUrl+"?page="+page+"&size=6")
  //   .pipe(
  //     map(response=> {
  //       console.log(response);
        
  //       const data =response;
  //       return data;
  //     })
  //   );
  // }
  getElectronicListPaginate(thePage:number,thePageSize:number):Observable<GetResponceElectronicDevice>{
    const getUrl=`${this.baseUrl}?page=${thePage}&size=${thePageSize}`;
    return this.http.get<GetResponceElectronicDevice>(getUrl);
  }
}
interface GetResponceElectronicDevice{
  content:{
    electronicDevices:ElectronicDevice[];
  }   
    size:number;
    totalElements:number;
    totalPages:number;
    number:number;
    first:boolean;
    last:boolean;
    empty:boolean;
}
