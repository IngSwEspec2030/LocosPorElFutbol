import {Injectable} from '@angular/core';
import {ActivityInterface} from '../../interfaces/activity.interface';
import {HttpClient} from '@angular/common/http';
import {Activity} from "../../../../../../project/src/app/components/interfaces/activity.interface";

@Injectable({
    providedIn: 'root'
})
export class ActivityService {

    private baseUrl = 'http://localhost:8080/';

    constructor(
        private http: HttpClient,
    ) {
    }

    getSites(param?: string): Promise<any[]> {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<any[]>(`${this.baseUrl}sitio/list`,
                {headers}).subscribe(result => {
                    resolve(result);
                },
                error => {
                    console.info(error);
                    reject(error);
                });
        });
    }

    createActivity(activity: ActivityInterface) {
        return new Promise((resolve, reject) => {
            const activitySave = activity;

            const headers = {
                'Content-Type': 'application/json'
            };

            const formData = {
                categoria: activitySave.categoria,
                descripcion: activitySave.descripcion,
                estado: parseInt(String(activitySave.estado), 10),
                nombreActividad: activitySave.nombreActividad,
                precioBase: parseInt(activitySave.precioBase, 10),
                review: activitySave.review || 5,
                idSitio: 2//activitySave.idSitio
            };
            return this.http.post<any>(`${this.baseUrl}activity/create`, formData, {headers}).subscribe(response => {
                    resolve({status: 201});
                },
                error => {
                    reject(error);
                });
        });
    }
}
