import {HttpClient, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Usuario} from '../../interfaces/usuario.interface';

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    private url = 'http://localhost:8080/getAutenticacion';


    constructor(private http: HttpClient) {
    }

    public getAtutenticar(email?: string, password?: string){
        let params = new HttpParams().set('email', email).set('passWord', password)
        const headers = {
            "Content-Type": "application/json",
        };
        return this.http.get<Usuario>(this.url, {params, headers});

    }
}

