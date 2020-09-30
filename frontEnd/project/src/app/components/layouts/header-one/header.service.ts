import {Injectable} from '@angular/core';
import {Place} from '../../interfaces/place.interface';
import {HttpClient} from '@angular/common/http';
import { Usuario } from '../../interfaces/usuario.interface';
import { Categorias } from '../../interfaces/categorias';

@Injectable({
    providedIn: 'root'
})
export class HeaderService {

    private placeUrl = 'http://localhost:8080/sitio/listDepartments';
    private categoriesUrl = 'http://localhost:8080/getCategories';

    constructor(private http: HttpClient) {
    }

    getPlaces(): Promise<Place[]> {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<Place[]>(this.placeUrl,
                {headers}).subscribe(result => {
                    resolve(result);
                },
                error => {
                    console.info(error);
                    reject(error);
                });
        });
    }


    getCategorias(): Promise<String[]> {
        return new Promise((resolve, reject) => {
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<String[]>(this.categoriesUrl,
                {headers}).subscribe(result => {
                    resolve(result);
                },
                error => {
                    console.info(error);
                    reject(error);
                });
        });
    }

    obtenerLoginUser(): Promise<Usuario> {
        return JSON.parse(localStorage.getItem('userAutenticado'));
    }
    
}
