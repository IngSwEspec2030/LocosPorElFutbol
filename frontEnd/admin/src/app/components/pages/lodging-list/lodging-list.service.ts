import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LodgingListService {
 
  private baseUrl = 'http://localhost:8080/';
  
  constructor(
    private http: HttpClient
  ) { }

  getlodgings(param?: string): any[] | Promise<any[]> {
    return new Promise((resolve, reject) => {
      const headers = {
          'Content-Type': 'application/json'
      };
      this.http.get<any[]>(`${this.baseUrl}lodging/list`,
          {headers}).subscribe(result => {
              resolve(result);
          },
          error => {
              console.info(error);
              reject(error);
          });
  });
  }
  deleteLodging(lodgingId: any) {
    return new Promise((resolve, reject) => {
      const headers = {
          'Content-Type': 'application/json'
      };
      this.http.delete<any[]>(`${this.baseUrl}lodging/delete/${lodgingId}/hospedaje`,
          {headers}).subscribe(result => {
              resolve({status: 'ok'});
          },
          error => {
              console.info(error);
              reject(error);
          });
  });
  }
}
