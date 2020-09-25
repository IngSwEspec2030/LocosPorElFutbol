import { HttpClient, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../../interfaces/usuario.interface';

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    private url = 'http://localhost:8080/getAutenticacion';



    constructor(private http: HttpClient) {
    }

    getAtutenticar(email?: string, password?: string): Promise<Usuario> {
        let params = new HttpParams().set('email', email).set('passWord', password)

        return new Promise((resolve, reject) => {
            const url = `${this.url}`;
            const headers = {
                'Content-Type': 'application/json'
            };
            this.http.get<Usuario>(url,
                { params, headers }).subscribe(result => {
                    resolve(result);
                },
                    error => {
                        console.info(error);
                        reject(error);
                    });
        });
    }    
}

