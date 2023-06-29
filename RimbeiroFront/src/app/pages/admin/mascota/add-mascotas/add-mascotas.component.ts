import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { MascotaService } from 'src/app/services/mascota.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-mascotas',
  templateUrl: './add-mascotas.component.html',
  styleUrls: ['./add-mascotas.component.css']
})
export class AddMascotasComponent implements OnInit {

  usuarios:any=[];

  mascota = {
    usuario:{
      id : ''
    },
    nombre : '',
    especie: '',
    raza: '',
    fechaNacimiento: '',
    peso: '',
    caracteristicas: ''
  }

  constructor(
    private mascotaService:MascotaService,
    private usuarioService:UsuarioService,
    private snack:MatSnackBar,
    private router:Router,
    public login:LoginService
    ) { }

  ngOnInit(): void {
    this.usuarioService.listarUsuarios().subscribe(
      (dato:any) => {
        this.usuarios = dato;
        console.log(this.usuarios);
      }, (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los datos','error');
      }
    )

    this.mascota.usuario.id = this.login.getId();
  }

  especiePermitida(especie: string): boolean {
    const especiesPermitidas = ['perro', 'gato', 'conejo', 'loro', 'perico', 'hamster', 'huron', 'otro'];
    return especiesPermitidas.includes(especie);
  }

  guardarMascota(){
    console.log(this.mascota);
    if(this.mascota.nombre.trim() == '' || this.mascota.nombre == null){
      this.snack.open('El Nombre es requerido','',{
        duration:3000
      });
      return;
    }
    else if(this.mascota.especie.trim() == '' || this.mascota.especie == null){
      this.snack.open('La especie es solicitada','',{
        duration:3000
      });
      return;
    }
    else if(this.mascota.raza.trim() == '' || this.mascota.raza == null){
      this.snack.open('Necesitamos saber la raza','',{
        duration:3000
      });
      return;
    }   
    else if(this.mascota.caracteristicas.trim() == '' || this.mascota.caracteristicas == null){
      this.snack.open('Necesitamos saber algunas caracteriscticas','',{
        duration:3000
      });
      return;
    }
this.mascotaService.agregarMascota(this.mascota).subscribe(
  (data) => {
    console.log(data);
    Swal.fire('Mascota Guardada','La mascota se guardo correctamente','success');
    this.mascota = {
      usuario:{
      id : ''
    },
    nombre : '',
    especie: '',
    raza: '',
    fechaNacimiento: '',
    peso: '',
    caracteristicas: ''
    }

    if (this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN') {
      this.router.navigate(['/admin/mascotas']);
    } else {
      this.router.navigate(['/user-dashboard/mascotalogin', this.login.getId()]);
    }
  },

  (error) => {
    Swal.fire('Error','Error al guardar la mascota','error');
  }
)

  }

}
