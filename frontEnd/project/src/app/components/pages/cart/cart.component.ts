import { Component, OnInit } from '@angular/core';
import { CartService } from './cart.service'
import { QuotationDetails } from '../../interfaces/ctemporal.interface';
import { Quotation } from '../../interfaces/quotation.interface';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  subtotal:number;
  iva:number;
  total:number;
  cotizacion: QuotationDetails;
  quotation: Quotation = new Quotation();
  constructor( private cartService:CartService) {

  }

  ngOnInit(): void {
    this.cotizacion= JSON.parse(localStorage.getItem("Cotizacion")) as QuotationDetails;
    this.subtotal = this.cotizacion.seleccionProvedores
    .map(c => c.costoPersona)
    .reduce(
        (sum: number, values) => sum + values,
        0
    );
    this.subtotal= this.subtotal*this.cotizacion.numPersonas;
    this.iva= this.subtotal*0.19;
    this.total= this.subtotal+this.iva;
  }


  cotizar(){
    this.quotation.fechaCotizacion = this.cotizacion.fechaCotizacion;
    this.quotation.fechaInicio = new Date(this.cotizacion.fechaInicio).valueOf();
    this.quotation.fechaFin = new Date(this.cotizacion.fechaFin).valueOf();
    this.quotation.idActividad = this.cotizacion.seleccionProvedores[0].id;
    this.quotation.idHospedaje = this.cotizacion.seleccionProvedores[1].id;
    this.quotation.idTransporte = this.cotizacion.seleccionProvedores[2].id;
    this.quotation.numPersonas= this.cotizacion.numPersonas;
    this.cartService.insertRunTicket(this.quotation).subscribe(
      result => {

      },
      err => {

      }
    );
  }

  discart(){

  }


}
