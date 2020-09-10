import { Injectable } from "@angular/core";

@Injectable({
    providedIn: "root",
})
export class CartService {
    constructor() {}

    getinfoBySiteId2(): any {
        return [
            {
                seleccionProvedores: [
                    {
                        idActividad: 1,
                        precioBase: 25000,
                        nombre: "Salento Trakking Tour",
                    },
                    {
                        idTransportadora: 1,
                        costoPersona: 40000,
                        nombre: "Expreso Gacela",
                    },
                    {
                        idHospedaje: 1,
                        costoPersona: 40000,
                        nombre: "Hotel 1",
                    },
                ],
                nombre: "",
                email: "",
                fechaCotizacion: "",
                fechaInicio: "",
                fechaFin: "",
            },
        ];
    }
}
