import {Component, OnInit} from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {HomeService} from './home.service';

@Component({
    selector: 'app-one-four',
    templateUrl: './home-one.component.html',
    styleUrls: ['./home-one.component.scss']
})
export class HomeOneComponent implements OnInit {
    model: NgbDateStruct;

    activities: any;

    constructor(private homeService: HomeService) {

    }

    // @ts-ignore
    ngOnInit(): void {
        this.getActivities();
    }

    private async getActivities() {
        this.activities = await this.homeService.getActivities();
    }


}
