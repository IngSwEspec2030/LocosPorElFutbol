import {Component, OnInit} from '@angular/core';
import {ListActivityService} from './list-activity.service';
import {NgbModalConfig, NgbModal} from '@ng-bootstrap/ng-bootstrap';


@Component({
    selector: 'app-list-activity',
    templateUrl: './list-activity.component.html',
    styleUrls: ['./list-activity.component.scss'],
    providers: [NgbModalConfig, NgbModal]
})
export class ListActivityComponent implements OnInit {

    public activities = [];

    constructor(
        private listActivityService: ListActivityService,
        private modalService: NgbModal) {
        this.getActivities();
    }

    ngOnInit(): void {
    }

    async getActivities() {
        this.activities = await this.listActivityService.getActivities();
        this.activities.sort((a, b) => {
            return (a['nombreActividad'] > b['nombreActividad']) ? 1 : -1;
        });
    }

    open(content) {
        this.modalService.open(content);
    }
}
