import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivityService} from './activity-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    selector: 'app-add-listing',
    templateUrl: './add-activity.component.html',
    styleUrls: ['./add-activity.component.scss']
})
export class AddActivityComponent implements OnInit {

    public showMessage = false;
    public message = '';
    public errorMessage = false;
    public activityId = null;

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

    constructor(private activityService: ActivityService, private route: ActivatedRoute) {
        this.getSites();
    }

    ngOnInit(): void {
        this.activityId = this.route.snapshot.params.id;
        if (this.activityId) {
            this.getActivity(this.activityId);
        }
    }

    async getActivity(activityId) {
        const activity = await this.activityService.getActivityById(activityId);
        this.form.controls['nombreActividad'].setValue(activity['nombreActividad']);
        this.form.controls['categoria'].setValue(activity['categoria']);
        this.form.controls['descripcion'].setValue(activity['descripcion']);
        this.form.controls['precioBase'].setValue(activity['precioBase']);
        this.form.controls['estado'].setValue(activity['estado']);

        const siteId = activity['sitioTuristico']['id_sitio'];
        setTimeout(() => {
            const filteredSites = this.sites.filter(site => site.id === siteId);
            const index = this.sites.indexOf(filteredSites[0]);
            this.form.controls['idSitio'].setValue(this.sites[index]);
        }, 1000);
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
        this.activityService.upsertActivity(this.form.value, this.activityId)
            .then(result => {
                if (result['status']) {
                    this.showMessage = true;
                    this.message = 'Actividad creada exitosamente';
                    window.scrollTo(0, 0);
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
