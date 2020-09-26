import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TransportInterface} from '../../interfaces/transport.interface';

@Injectable({
    providedIn: 'root'
})
export class TransportService {

    private baseUrl = 'http://localhost:8080/';

    constructor(private http: HttpClient) {
    }

    getActivities(): Promise<any[]> {
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

    upsertTransport(transport: TransportInterface, transportId?: number, images?: Array<string>) {
        return new Promise((resolve, reject) => {
            const transportSave = transport;
            const path = (transportId) ? 'transport/update' : 'transport/create';

            const headers = {
                'Content-Type': 'application/json'
            };

            const formData = {
                nombreRepresentante: transportSave.nombreRepresentante,
                descripcion: transportSave.descripcion,
                costoPersona: parseInt(String(transportSave.costoPersona), 10),
                telefono: transportSave.telefono,
                tipo: 'transporte',
                transportadora: transportSave.transportadora,
                userId: 3, //TODO ADMIN
                idActividades: transportSave['actividades'].map( tr => parseInt(tr.id, 10) ),
                images
            };

            if (transportId) {
                formData['idTransporte'] = transportId;
            }

            return this.http.post<any>(`${this.baseUrl}${path}`, formData, {headers}).subscribe(response => {
                    resolve({status: 201});
                },
                error => {
                    reject(error);
                });
        });
    }
}
