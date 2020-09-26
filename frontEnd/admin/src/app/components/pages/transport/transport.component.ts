import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TransportService} from '../transport/transport.service';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-transport',
  templateUrl: './transport.component.html',
  styleUrls: ['./transport.component.scss']
})
export class TransportComponent implements OnInit {

    public form: FormGroup;
    public showMessage = false;
    public message = '';
    public errorMessage = false;
    public transportId = null;
    public submitted = false;

    public selectedFile: File;
    public activities = [];
    public images = [];

    public urlPath = 'http://localhost:8080/public/images/';

    constructor(
        private transportService: TransportService,
        private route: ActivatedRoute,
        private httpClient: HttpClient) {
        this.getActivities();
    }

    ngOnInit(): void {
        this.transportId = this.route.snapshot.params.id;
        if (this.transportId) {
            //this.getTransport(this.transportId);
        }

        this.form = new FormGroup({
            transportadora: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            nombreRepresentante: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            telefono: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            actividades: new FormControl('', Validators.required),
            descripcion: new FormControl('', [
                Validators.required,
                Validators.minLength(10)
            ]),
            costoPersona: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ])
        });
    }
/*
    async getTransport(transportId) {
        const Transport = await this.transportService.getTransportById(transportId);
        this.form.controls['nombreActividad'].setValue(Transport['nombreActividad']);
        this.form.controls['categoria'].setValue(Transport['categoria']);
        this.form.controls['descripcion'].setValue(Transport['descripcion']);
        this.form.controls['precioBase'].setValue(Transport['precioBase']);
        this.form.controls['estado'].setValue(Transport['estado']);

        this.images = Transport['images'];

        const siteId = Transport['sitioTuristico']['id_sitio'];
        setTimeout(() => {
            const filteredSites = this.activities.filter(site => site.id === siteId);
            const index = this.activities.indexOf(filteredSites[0]);
            this.form.controls['idSitio'].setValue(this.activities[index]);
        }, 1000);
    }*/

    async getActivities() {
        this.activities = await this.transportService.getActivities();
        this.activities = this.activities.map(activity => {
            return {
                id: activity['id'],
                name: activity['nombreActividad']
            };
        });
    }

    public onFileChanged(event) {
        // Select File
        this.selectedFile = event.target.files[0];
        this.onUpload();
    }

    onUpload() {
        const uploadImageData = new FormData();
        uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);

        this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, {observe: 'response'})
            .subscribe((response) => {
                    if (response.status === 201) {
                        this.images.push(response.body['file']);
                    } else {
                        console.info(response);
                    }
                }
            );
    }

    removeImage(image) {
        const index = this.images.indexOf(image);
        if (index > -1) {
            this.images.splice(index, 1);
        }
    }

    onSubmit(): void {
        this.submitted = true;
        if (this.form.invalid) {
            window.scrollTo(0, 0);
            return;
        }
        this.transportService.upsertTransport(this.form.value, this.transportId, this.images)
            .then(result => {
                if (result['status']) {
                    this.showMessage = true;
                    this.errorMessage = false;
                    this.message = 'Servicio de transporte guardado exitosamente';
                    window.scrollTo(0, 0);
                }
            })
            .catch(error => {
                this.showMessage = true;
                this.errorMessage = true;
                this.message = 'Ha ocurrido un error en la creación del servicio de transporte';
                window.scrollTo(0, 0);
            });
    }

}
