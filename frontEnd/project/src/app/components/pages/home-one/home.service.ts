import {Injectable} from '@angular/core';
import {Activity} from '../../interfaces/activity.interface';
import {HttpClient} from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class HomeService {

    private url = 'https://run.mocky.io/v3/86231eec-22c0-4f6f-b24a-8608a89e0681';
    private placeUrl = 'https://run.mocky.io/v3/df80af57-3897-47b7-8229-4d3916f28dd2';

    constructor(private http: HttpClient) {
    }

    getActivities(): Promise<Activity[]> {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<Activity[]>(this.url,
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
