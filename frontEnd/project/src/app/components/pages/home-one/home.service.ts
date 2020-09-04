import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class HomeService {

    constructor() {
    }

    getActivities(): Array<any> {
        /**
         * Realizar servicio
         * **/

        return [
            {
                nombreSitioTuristico: 'Salento',
                nombreMunicipio: 'Salento',
                nombreDepartamento: 'Quindio',
                idActividad: 1,
                nombreActividad: 'SALENTO Y VALLE DE COCORA',
                estado: 1,
                ubicacion: '787,-9712',
                imagenesActividad: [
                    'assets/img/site_images/valle_cocora_1_1.jpg',
                    ''
                ],
                categoria: 'Trekking',
                precioBase: '180000',
                review: '5'
            },
            {
                nombreSitioTuristico: 'Parque Nacional Natural Los Nevados',
                nombreMunicipio: 'Manizales',
                nombreDepartamento: 'Caldas',
                idActividad: 2,
                nombreActividad: 'Tour por el Nevado del Ruiz y los termales',
                estado: 1,
                ubicacion: '787,-9712',
                imagenesActividad: [
                    'assets/img/site_images/parque_nevados_2_1.jpg',
                    ''
                ],
                categoria: 'Trekking',
                precioBase: '480000',
                review: '5'
            },
            {
                nombreSitioTuristico: 'Alta Guajira',
                nombreMunicipio: 'Rioacha',
                nombreDepartamento: 'Guajira',
                idActividad: 3,
                nombreActividad: 'Cabo de la Vela y Punta Gallinas\n',
                estado: 1,
                ubicacion: '787,-9712',
                imagenesActividad: [
                    'assets/img/site_images/alta_guajira_4_1.jpg',
                    ''
                ],
                categoria: 'Trekking',
                precioBase: '770000',
                review: '5'
            },
            {
                nombreSitioTuristico: 'Desierto Tatacoa',
                nombreMunicipio: 'Neiva',
                nombreDepartamento: 'Huila',
                idActividad: 4,
                nombreActividad: 'Tour Desierto Tatacoa\n',
                estado: 1,
                ubicacion: '787,-9712',
                imagenesActividad: [
                    'assets/img/site_images/tatacoa_3_1.jpg',
                    ''
                ],
                categoria: 'Trekking',
                precioBase: '440000',
                review: '5'
            },
            {
                nombreSitioTuristico: 'Bogotá',
                nombreMunicipio: 'Bogota',
                nombreDepartamento: 'Cundinamarca',
                idActividad: 5,
                nombreActividad: 'Tour Laguna Guatavita\n',
                estado: 1,
                ubicacion: '787,-9712',
                imagenesActividad: [
                    'assets/img/site_images/guatavita_5_1.jpg',
                    ''
                ],
                categoria: 'Trekking',
                precioBase: '180000',
                review: '5'
            },
            {
                nombreSitioTuristico: 'Bogotá',
                nombreMunicipio: 'Bogota',
                nombreDepartamento: 'Cundinamarca',
                idActividad: 5,
                nombreActividad: 'Excursión por el Parque Natural de Chicaque\n',
                estado: 1,
                ubicacion: '787,-9712',
                imagenesActividad: [
                    'assets/img/site_images/chicace_6_1.jpg',
                    ''
                ],
                categoria: 'Trekking',
                precioBase: '20000',
                review: '5'
            }
        ];
    }
}
