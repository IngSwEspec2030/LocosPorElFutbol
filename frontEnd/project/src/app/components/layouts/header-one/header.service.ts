import {Injectable} from '@angular/core';
import {Place} from '../../interfaces/place.interface';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class HeaderService {

    private placeUrl = 'https://run.mocky.io/v3/df80af57-3897-47b7-8229-4d3916f28dd2';
    constructor(private http: HttpClient) {
    }

    getPlaces(): Promise<Place[]> {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<Place[]>(this.placeUrl,
                {headers}).subscribe(result => {
                    resolve(result);
                },
                error => {
                    console.info(error);
                    reject(error);
                });
        });
    }
}
