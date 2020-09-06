import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
 

@Component({
  selector: 'app-provider-modal',
  templateUrl: './provider-modal.component.html',
  styleUrls: ['./provider-modal.component.scss']
})
export class ProviderModalComponent implements OnInit {
  
  @Input() name;
  constructor (public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
  }




}
