import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LodgingInterface } from "src/app/components/interfaces/lodging.interface";

@Injectable({
    providedIn: "root",
})
export class LodgingService {
    private baseUrl = "http://localhost:8080/";

    constructor(private http: HttpClient) {}

    getLodgingById(lodgingId: any) {
        const headers = {
            "Content-Type": "application/json",
        };
        const vUrl = `${this.baseUrl}lodging/get/${lodgingId}`;
        return this.http.get(vUrl, { headers });
    }

    getActivities() {
        const headers = {
            "Content-Type": "application/json",
        };
        const vUrl = `${this.baseUrl}activity/list`;
        return this.http.get(vUrl, { headers });
    }
 
    upsertLodging(
        lodging: LodgingInterface,
        lodgingId: number,
        images?: Array<string>
    ) {

      const lodgingSave = lodging;

      const path = lodgingId ? "lodging/update" : "lodging/create";

        const headers = {
            "Content-Type": "application/json",
        };

        const formData = {
            nombre: lodgingSave.nombre,
            costoPersona: parseInt(String(lodgingSave.costoPersona), 10),
            direccion: lodgingSave.direccion,
            telefono: lodgingSave.telefono,
            tipo: "hospedaje",
            userId: 3, //TODO ADMIN
            idActividades: lodgingSave["actividades"].map((tr) =>
                parseInt(tr.id, 10)
            ),
            images
        };

        if (lodgingId) {
            formData["idHospedaje"] = lodgingId;
        }

        const vUrl = `${this.baseUrl}${path}`;

        return this.http.post(vUrl,formData,{headers});
    }
}
