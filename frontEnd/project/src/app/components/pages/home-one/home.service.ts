import {Injectable} from '@angular/core';
import {Activity} from '../../interfaces/activity.interface';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class HomeService {

    private url = 'https://run.mocky.io/v3/86231eec-22c0-4f6f-b24a-8608a89e0681';

    constructor(private http: HttpClient) {
    }

    getActivities() {
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
