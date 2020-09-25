import {Component, OnInit} from '@angular/core';
import {HeaderService} from './header.service';
import {Place} from '../../interfaces/place.interface';
import { Usuario } from '../../interfaces/usuario.interface';
import { Router } from '@angular/router';

@Component({
    selector: 'app-header-one',
    templateUrl: './header-one.component.html',
    styleUrls: ['./header-one.component.scss']
})
export class HeaderOneComponent implements OnInit {

    private places: Place[];
    public usuarioAtenticado:Usuario;

    constructor(
        private headerService: HeaderService,
        private router: Router) {
    }

    ngOnInit(): void {
        this.getPlaces();
        this.getUsuarioAutenticado();
    }

    private async getPlaces(): Promise<Place[]> {
        this.places = await this.headerService.getPlaces();
        localStorage.setItem('places', JSON.stringify(this.places));
        return this.places;
    }

    private async getUsuarioAutenticado(): Promise<Usuario> {
        this.usuarioAtenticado = await this.headerService.obtenerLoginUser();
        return this.usuarioAtenticado;
    }

    cerrarSesion(){
        localStorage.removeItem('userAutenticado');
        window.location.reload();
    }
}
