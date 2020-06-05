import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private baseUrl = "http://localhost:8080/api/users";

  constructor(private http: HttpClient) { }
  postUser(user: User) {
    this.http.post(this.baseUrl, user).subscribe();
  }

  EmailIsExists(email):Observable<User> {
  console.log(this.baseUrl+`/${email}/`);
  
   return this.http.get<User>(this.baseUrl+`/${email}/`);
  }
}
