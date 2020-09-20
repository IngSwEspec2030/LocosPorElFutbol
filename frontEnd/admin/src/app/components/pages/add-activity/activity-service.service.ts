import {Injectable} from '@angular/core';
import {Activity} from '../../interfaces/activity.interface';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ActivityServiceService {

    private baseUrl = 'http://';
    private createUrl = '';

    constructor(
        private http: HttpClient,
    ) {
    }

    createActivity(activity: Activity) {
        return new Promise((resolve, reject) => {
            const activitySave = activity;

            const formData = {
                idActividad: activitySave.idActividad,
                categoria: activitySave.categoria,
                descripcion: activitySave.descripcion,
                estado: activitySave.estado,
                nombreActividad: activitySave.nombreActividad,
                precioBase: activitySave.precioBase,
                review: activitySave.review,
                idSitio: activitySave.idSitio
            };
            return this.http.post<any>(`${this.baseUrl}activity/`, formData).subscribe(response => {
                    resolve(response);
                },
                error => {
                    //this.messageService.addError(error.error.message);
                    reject(error);
                });
        });
    }
}
