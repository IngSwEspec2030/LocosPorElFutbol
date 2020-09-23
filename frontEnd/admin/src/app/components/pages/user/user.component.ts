import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from './user.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
    public form: FormGroup;
    public showMessage = false;
    public message = '';
    public errorMessage = false;
    public userId = null;
    public submitted = false;

    public sites = [];
    public isProvider = false;

    constructor(
        //private UserService: UserService,
        private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.form = new FormGroup({
            tipousuario: new FormControl('1', Validators.required),
            apellidos: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            nombres: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            nombreProveedor: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            nombreRepresentante: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            telefono: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            identificacion: new FormControl('', [
                Validators.required,
                Validators.minLength(3)
            ]),
            email: new FormControl('', [
                Validators.required,
                Validators.email,
                Validators.minLength(3)
            ]),
            password: new FormControl('', [
                Validators.required,
                Validators.minLength(8)
            ]),
            password2: new FormControl('', [
                Validators.required,
                Validators.minLength(8)
            ])
        });
    }

    changeUserType(userType): void {
        if (userType === 2) {
            this.isProvider = true;
        } else {
            this.isProvider = false;
        }
    }

    onSubmit(): void {
        this.submitted = true;
        if (this.form.invalid) {
            window.scrollTo(0, 0);
            return;
        }

        /*
        this.activityService.upsertActivity(this.form.value, this.activityId)
            .then(result => {
                if (result['status']) {
                    this.showMessage = true;
                    this.message = 'Actividad creada exitosamente';
                    window.scrollTo(0, 0);
                }
            })
            .catch(error => {
                this.showMessage = true;
                this.errorMessage = true;
                this.message = 'Ha ocurrido un error en la creación de la actividad';
                window.scrollTo(0, 0);
            });

         */
    }

}
