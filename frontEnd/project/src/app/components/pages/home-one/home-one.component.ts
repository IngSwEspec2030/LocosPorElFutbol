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

    ngOnInit(): void {
        setTimeout(() => {
            this.activities = this.homeService.getActivities();
        }, 1000);

    }


}
