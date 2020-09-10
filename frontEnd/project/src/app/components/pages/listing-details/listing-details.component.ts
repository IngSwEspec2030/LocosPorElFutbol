import { Component, OnInit } from "@angular/core";
import { ListingDetailsService } from "./listing-details.service";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ProviderModalComponent } from "./provider-modal/provider-modal.component";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Quotation } from "../../interfaces/quotation.interface";
import { DomSanitizer } from '@angular/platform-browser';
import { error } from '@angular/compiler/src/util';
import { ActivityDetails } from '../../interfaces/activityDetails.interface';


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
    quotation: Quotation;
    src:string;
    url: any;
    base:boolean;
    showToast: boolean;
    
    constructor(
        private dom: DomSanitizer,
        private listingDetailsService: ListingDetailsService,
        private modalService: NgbModal,
        private formBuilder: FormBuilder,
        private router: Router,
        private route: ActivatedRoute
    ) {
        this.loadContent();
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe((params) => {
            this.getDetails(params.id);
        });
    }

    private async getDetails(id: number): Promise<ActivityDetails[]> {
        const details = await this.listingDetailsService.getActivities(id);
        this.details = details;
        this.arryPrices[0] = this.details.precioBase;
        this.src='https://www.google.com/maps/embed/v1/place?q='+this.details.latitud+','+this.details.longitud+'&key=AIzaSyBCO2sM4U_hk39ps6YmJs5CTXUBPhkvkU8';
        this.url=this.dom.bypassSecurityTrustResourceUrl(this.src); 
        return this.details;

    }



    loadContent(): void {
        this.frmGroup = this.formBuilder.group({
            txtName: [null, [Validators.required]],
            txtEmail: [null, [Validators.required], Validators.maxLength(60), Validators.email],
            txtDate: [null, [Validators.required]],
            numPersonas: [1],
            txtMessage: [null],
            // activity: [null, [Validators.required]],
            // transportProvider: [null, [Validators.required]],
            // hotelProvider: [null, [Validators.required]],
        });
    }

    calculateTotalPrice(price: number, type: string) {
        this.base=true;
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
      this.frmGroup.updateValueAndValidity();
      if (this.frmGroup.invalid) {
        this.showToast=true;
        return;
      }
      this.getQuotation();
    }
 
    getQuotation() {
        this.quotation.fechaCotizacion= new Date();
        this.quotation.numPersonas=this.frmGroup.get("numPersons").value;
        this.quotation.idHospedaje=this.frmGroup.get("").value;
        this.quotation.idActividad=this.frmGroup.get("").value;
        this.quotation.idTransporte=this.frmGroup.get("").value;
        this.quotation.fechaInicio=this.frmGroup.get("txtDate").value;
        this.quotation.fechaFin=this.frmGroup.get("txtDate").value;
        this.router.navigate(['/cart']);
   }

    getProviderDetail(item:any) {
        const modalRef = this.modalService.open(ProviderModalComponent);
        modalRef.componentInstance.name = item;
    }
}
