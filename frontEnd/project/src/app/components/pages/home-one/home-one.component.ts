import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {HomeService} from './home.service';
import {Activity} from '../../interfaces/activity.interface';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-one-four',
    templateUrl: './home-one.component.html',
    styleUrls: ['./home-one.component.scss']
})
export class HomeOneComponent implements OnInit {
    model: NgbDateStruct;
    activities: Activity[];

    @ViewChild('actividades') actividades: ElementRef;

    places = JSON.parse(localStorage.getItem('places'));

    form = new FormGroup({
        searchActivity: new FormControl('', Validators.minLength(2)),
        searchPlace: new FormControl('Lugares'),
        searchCalendar: new FormControl(''),
    });

    constructor(private homeService: HomeService, private router: Router) {
    }

    ngOnInit(): void {
        this.getActivities();
    }

    private async getActivities(): Promise<Activity[]> {
        this.activities = await this.homeService.getActivities();
        return this.activities;
    }

    onSubmit(): void {
        console.log(this.form.value);
        localStorage.setItem('fechaViaje', JSON.stringify(this.form.value.searchCalendar));
        this.actividades.nativeElement.scrollIntoView();
    }

}
