import { Injectable } from "@angular/core";
import { Quotation } from '../../interfaces/quotation.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: "root",
})
export class CartService {

    private url = "http://localhost:8080/crear/cotizacion"

    constructor(private http: HttpClient) {}


  public insertRunTicket(pTicket:Quotation) {
    const headers = {
        'Content-Type': 'application/json'
    };
    const vUrl = `${
      this.url}`;
    return this.http
      .post(vUrl, pTicket, {headers})
  }
}
