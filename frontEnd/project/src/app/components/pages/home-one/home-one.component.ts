import {Component, OnInit} from '@angular/core';
import {NgbDate, NgbCalendar, NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import {HomeService} from './home.service';

@Component({
    selector: 'app-one-four',
    templateUrl: './home-one.component.html',
    styleUrls: ['./home-one.component.scss']
})
export class HomeOneComponent implements OnInit {

    hoveredDate: NgbDate | null = null;
    fromDate: NgbDate | null;
    toDate: NgbDate | null;

    activities: any;

    constructor(private calendar: NgbCalendar,
                public formatter: NgbDateParserFormatter,
                private homeService: HomeService) {

    }

    ngOnInit(): void {
        setTimeout(() => {
            this.activities = this.homeService.getActivities();
        }, 1000);

    }

    onDateSelection(date: NgbDate) {
        if (!this.fromDate && !this.toDate) {
            this.fromDate = date;
        } else if (this.fromDate && !this.toDate && date && date.after(this.fromDate)) {
            this.toDate = date;
        } else {
            this.toDate = null;
            this.fromDate = date;
        }
    }

    isHovered(date: NgbDate) {
        return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
    }

    isInside(date: NgbDate) {
        return this.toDate && date.after(this.fromDate) && date.before(this.toDate);
    }

    isRange(date: NgbDate) {
        return date.equals(this.fromDate) || (this.toDate && date.equals(this.toDate)) || this.isInside(date) || this.isHovered(date);
    }

    validateInput(currentValue: NgbDate | null, input: string): NgbDate | null {
        const parsed = this.formatter.parse(input);
        return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
    }

}
