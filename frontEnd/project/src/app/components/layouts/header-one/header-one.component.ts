import {Component, OnInit} from '@angular/core';
import {HeaderService} from './header.service';
import {Place} from '../../interfaces/place.interface';

@Component({
    selector: 'app-header-one',
    templateUrl: './header-one.component.html',
    styleUrls: ['./header-one.component.scss']
})
export class HeaderOneComponent implements OnInit {

    private places: Place[];

    constructor(private headerService: HeaderService) {
    }

    ngOnInit(): void {
        this.getPlaces();
    }

    private async getPlaces(): Promise<Place[]> {
        this.places = await this.headerService.getPlaces();
        localStorage.setItem('places', JSON.stringify(this.places));
        return this.places;
    }

}
