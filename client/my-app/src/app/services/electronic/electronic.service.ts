import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ElectronicDevice } from 'src/app/common/electronic-device';

@Injectable({
  providedIn: 'root'
})
export class ElectronicService {
private baseUrl="http://localhost:8080/api/electronic-devices";
  constructor(private http:HttpClient) { }
  getElectronicDevices():Observable<ElectronicDevice[]>{
    return this.http.get<ElectronicDevice[]>(this.baseUrl);
  }
}
