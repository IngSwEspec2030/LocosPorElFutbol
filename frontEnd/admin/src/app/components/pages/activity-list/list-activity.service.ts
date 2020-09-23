import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class ListActivityService {

    private baseUrl = 'http://localhost:8080/';

    constructor(
        private http: HttpClient,
    ) {
    }

    getActivities(param?: string): Promise<any[]> {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<any[]>(`${this.baseUrl}activity/list`,
                {headers}).subscribe(result => {
                    resolve(result);
                },
                error => {
                    console.info(error);
                    reject(error);
                });
        });
    }

    deleteActivity(activityId: number) {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.delete<any[]>(`${this.baseUrl}activity/delete/${activityId}`,
                {headers}).subscribe(result => {
                    resolve({status: 'ok'});
                },
                error => {
                    console.info(error);
                    reject(error);
                });
        });
    }

}
