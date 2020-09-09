import {Injectable} from '@angular/core';
import {Activity} from '../../interfaces/activity.interface';
import {HttpClient} from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class HomeService {

    private url = 'http://localhost:8080/getActivities';

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
