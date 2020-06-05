import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseUrl="http://localhost:8080/api/users/alireza.ra@gmail.com/";

  constructor(private http:HttpClient) { }
  public getUser():Observable<User>{
    return this.http.get<User>(this.baseUrl);
  }
}
