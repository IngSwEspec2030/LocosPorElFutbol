import { Component, OnInit } from "@angular/core";
import { ListingDetailsService } from "./listing-details.service";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ProviderModalComponent } from "./provider-modal/provider-modal.component";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";

@Component({
    selector: "app-listing-details",
    templateUrl: "./listing-details.component.html",
    styleUrls: ["./listing-details.component.scss"],
})
export class ListingDetailsComponent implements OnInit {
    details: any;
    hotelSelection: any;
    arryPrices: Array<number> = [3];
    totalPrice: number;
    closeResult = "";
    frmGroup: FormGroup;
    submitted: boolean;

    constructor(
        private listingDetailsService: ListingDetailsService,
        private modalService: NgbModal,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute
    ) {
        this.loadContent();
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe((params) => {
            let details = this.listingDetailsService.getinfoBySiteId(params.id);
            this.details = details[0];
            this.arryPrices[0] = details[0].precioBase;
        });
    }

    loadContent(): void {
        this.frmGroup = this.formBuilder.group({
            txtName: [null, [Validators.required]],
            txtEmail: [null, [Validators.required]],
            txtDate: [null, [Validators.required]],
            numPersons: [null],
            txtMessage: [null],
            transportProvider: [null, [Validators.required]],
            hotelProvider: [null, [Validators.required]],
        });
    }

    calculateTotalPrice(price: number, type: string) {
        if (type == "t") {
            this.arryPrices[1] = price;
        } else {
            this.arryPrices[2] = price;
        }

        this.totalPrice = this.arryPrices.reduce(
            (sum: number, values) => sum + values,
            0
        );
    }

    public submit(): void {
      this.submitted = true;
      let date = this.frmGroup.controls["txtDate"].value;
      if (!date) {
        this.frmGroup.controls["txtDate"].setErrors({ required: true });
      }
  
      this.frmGroup.updateValueAndValidity();
      if (this.frmGroup.invalid) {
        return;
      }
      this.getTicket();
    }
 
    getTicket() {
      
   }

    getProviderDetail(item:any) {
        const modalRef = this.modalService.open(ProviderModalComponent);
        modalRef.componentInstance.name = item;
    }
}
