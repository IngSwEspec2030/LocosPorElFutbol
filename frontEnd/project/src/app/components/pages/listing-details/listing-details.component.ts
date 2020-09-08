import { Component, OnInit } from '@angular/core';
import { ListingDetailsService } from './listing-details.service';
import { NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { ProviderModalComponent } from './provider-modal/provider-modal.component';


@Component({
  selector: 'app-listing-details',
  templateUrl: './listing-details.component.html',
  styleUrls: ['./listing-details.component.scss']
})
export class ListingDetailsComponent implements OnInit {
  
  details: any;
  hotelSelection:any
  arryPrices: Array<number>=[3];
  totalPrice:number;
  closeResult = '';
  
  constructor(private listingDetailsService:ListingDetailsService,
    private modalService: NgbModal) {
    
   }

  ngOnInit(): void {
    let details=this.listingDetailsService.getinfoBySiteId();
    this.details=details[0]
    this.arryPrices[0]=details[0].precioBase;
  }
  

  calculateTotalPrice(price:number, type:string){

    if (type=='t') {
      this.arryPrices[1]=price;
    }
    else{
      this.arryPrices[2]=price;
    }

    this.totalPrice=this.arryPrices.reduce((sum: number, values) => sum + values, 0);
  }

  getProviderDetail($event){

    const modalRef = this.modalService.open(ProviderModalComponent);
    modalRef.componentInstance.name = 'World';
  }

}
