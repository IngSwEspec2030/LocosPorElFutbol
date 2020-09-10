import { Component, OnInit } from '@angular/core';
import { CartService } from './cart.service'

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  subtotal:number;
  cotizacion = [];
  constructor( private cartService:CartService) { }

  ngOnInit(): void {
    this.cotizacion= this.cartService.getinfoBySiteId2();
  }

  

}
