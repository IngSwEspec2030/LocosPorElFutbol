import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivityService} from './activity-service.service';

@Component({
    selector: 'app-add-listing',
    templateUrl: './add-activity.component.html',
    styleUrls: ['./add-activity.component.scss']
})
export class AddActivityComponent implements OnInit {

    public showMessage = false;
    public message = '';
    public errorMessage = false;

    public sites = [];

    form = new FormGroup({
        nombreActividad: new FormControl('', Validators.minLength(2)),
        categoria: new FormControl('categoria'),
        descripcion: new FormControl('', Validators.minLength(2)),
        estado: new FormControl('1'),
        precioBase: new FormControl('', Validators.minLength(2)),
        review: new FormControl('', Validators.minLength(2)),
        idSitio: new FormControl('idSitio'),
    });

    constructor(private activityService: ActivityService) {
        this.getSites();
    }

    ngOnInit(): void {
    }

    async getSites() {
        this.sites = await this.activityService.getSites();
        this.sites = this.sites.map(site => {
            return {
                id: site['id_sitio'],
                name: site['nombreSitio']
            };
        });
    }

    onSubmit(): void {
        this.activityService.createActivity(this.form.value)
            .then(result => {
                if (result['status']) {
                    this.showMessage = true;
                    this.message = 'Actividad creada exitosamente';
                }
            })
            .catch(error => {
                this.showMessage = true;
                this.errorMessage = true;
                this.message = 'Ha ocurrido un error en la creación de la actividad';
                window.scrollTo(0, 0);
            });
    }

}
