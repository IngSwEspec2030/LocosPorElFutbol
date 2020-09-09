import {Component, OnInit} from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {HomeService} from './home.service';
import {Activity} from '../../interfaces/activity.interface';

@Component({
    selector: 'app-one-four',
    templateUrl: './home-one.component.html',
    styleUrls: ['./home-one.component.scss']
})
export class HomeOneComponent implements OnInit {
    model: NgbDateStruct;
    activities: Activity[];

    constructor(private homeService: HomeService) {
    }

    // @ts-ignore
    ngOnInit(): void {
        this.getActivities();
    }

    private async getActivities(): Promise<Activity[]> {
        this.activities = await this.homeService.getActivities();
        return this.activities;
    }


}
