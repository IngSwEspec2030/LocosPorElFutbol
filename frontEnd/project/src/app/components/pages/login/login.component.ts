import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Usuario} from '../../interfaces/usuario.interface';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {CONFIG} from '../../../../assets/config';
import { NgbProgressbarConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent {
    usuario: Usuario;
    message: string;
    isLoad = false;
    form = new FormGroup({
        email: new FormControl('', Validators.required),
        password: new FormControl('', Validators.required)
    });

    constructor(
        private loginService: LoginService,
        private router: Router,
        config: NgbProgressbarConfig
        ) {
            config.max = 1000;
            config.striped = true;
            config.animated = true;
            config.type = "info";
            config.height = "6px";
    }

    ngOnInit(): void {
    }

    onSubmit(): void {
        if (this.form.value.email !== '' && this.form.value.password !== '') {
            this.isLoad=true;
            this.getUsusario();
        }
    }

    private async getUsusario(): Promise<Usuario> {
        this.usuario = await this.loginService.getAtutenticar(this.form.value.email, this.form.value.password);
        localStorage.setItem('userAutenticado', JSON.stringify(this.usuario));
        setTimeout(() => {
            window.location.href = CONFIG.adminPath;
            this.isLoad=false;
        }, 1000);
        return this.usuario;
    }


}
