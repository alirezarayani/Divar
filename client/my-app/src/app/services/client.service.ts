import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {catchError,map,tap} from 'rxjs/operators';
import { Client } from '../common/Client';
import { PageClient } from '../common/PageClient';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private url = 'http://localhost:8080/api/clients';

  private urlPage = 'http://localhost:8080/api/clients/get?page=';

  getClient(): Observable<Client[]>{
     return this.http.get<Client[]>(this.url);
  }

 getPageClient(page:number): Observable<PageClient>{
  var url = this.urlPage;
  url=url+page + "&size=5";
  return this.http.get<PageClient>(url)
  .pipe(
    map(response => {
 
      const data = response;
     
      return data ;
    }));
}
  constructor(private http : HttpClient) { }
  
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
   
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
   
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
   
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
