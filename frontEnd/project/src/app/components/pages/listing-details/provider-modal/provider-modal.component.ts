import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
 

@Component({
  selector: 'app-provider-modal',
  templateUrl: './provider-modal.component.html',
  styleUrls: ['./provider-modal.component.scss']
})
export class ProviderModalComponent implements OnInit {
  
  @Input() name: any;
  isLodging:boolean;
  arryImg: [];
  constructor (public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
    this.checkProvider();
  }


  checkProvider() {
    if (this.name.idHospedaje != undefined) {
      this.isLodging=true;
      this.arryImg=this.name.imagenesHospedaje;
    } else {
      this.isLodging=false;
      this.arryImg=this.name.imagenesTransporte;

    }
  }




}
