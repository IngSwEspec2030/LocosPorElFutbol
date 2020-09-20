import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivityService} from './activity-service.service';

@Component({
    selector: 'app-add-listing',
    templateUrl: './add-activity.component.html',
    styleUrls: ['./add-activity.component.scss']
})
export class AddActivityComponent implements OnInit {

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
    }

    ngOnInit(): void {
    }

    onSubmit(): void {
        this.activityService.createActivity(this.form.value);
    }

}
