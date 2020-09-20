import {Injectable} from '@angular/core';
import {ActivityInterface} from '../../interfaces/activity.interface';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ActivityService {

    private baseUrl = 'http://localhost:8080/';

    constructor(
        private http: HttpClient,
    ) {
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
