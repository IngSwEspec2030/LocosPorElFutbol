import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  subtotal:number;
  constructor() { }

  ngOnInit(): void {
  }

  getinfoBySiteId2(id:number) : any{

    return [
        {
          precioBase: 25000,
          idActividad: 1,
          nombreActividad:'Salento Trakking Tour',
          provedoresTransporte: [
            {idTransportadora:1 ,costoPersona: 40000, tipo: 'terrestre', transportadora:'Expreso Gacela'}
          ],
          provedoresHospedaje: [
            {idHospedaje:1 ,costoPersona: 40000, tipo: 'Glamping', nombre:'Hotel 1'},
          ]
          
        }
    ]
  }

}
