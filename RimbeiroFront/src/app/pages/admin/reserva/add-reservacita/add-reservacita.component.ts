import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { MascotaService } from 'src/app/services/mascota.service';
import { ReservaCitaService } from 'src/app/services/reserva-cita.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-reservacita',
  templateUrl: './add-reservacita.component.html',
  styleUrls: ['./add-reservacita.component.css']
})
export class AddReservacitaComponent implements OnInit {

  mascotas:any = [];
  veterinarios:any = [];

  reservaCita = {
    mascota:{
      id : ''
    },
    veterinario:{
      id : ''
    },
    fecha : '',
    hora : '',
    estado: true,
  }

  constructor(
    private reservaCitaService:ReservaCitaService, 
    private snack:MatSnackBar, 
    private router:Router, 
    private veterinarioService:VeterinarioService, 
    private mascotaService:MascotaService,
    public login:LoginService,
    private usuarioService:UsuarioService
  ) { }

  ngOnInit(): void {
    if(this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN'){
      this.mascotaService.listarMascotas().subscribe(
        (dato:any) => {
          this.mascotas = dato;
          console.log(this.mascotas);
        }, (error) => {
          console.log(error);
          Swal.fire('Error !!','Error al cargar las Mascotas','error');
        }
      );
      this.veterinarioService.listarVeterinarios().subscribe(
        (dato:any) => {
          this.veterinarios = dato;
          console.log(this.veterinarios);
        }, (error) => {
          console.log(error);
          Swal.fire('Error !!','Error al cargar los Veterinarios','error');
        }
      );
    }else{
      //listado de mascotas por usuario
      this.usuarioService.listarMascotasDeUsuario(this.login.getId()).subscribe(
        (dato: any) => {
          this.mascotas = dato;
          console.log(this.mascotas);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las mascotas');
        }
      );
      this.veterinarioService.listarVeterinarios().subscribe(
        (dato:any) => {
          this.veterinarios = dato;
          console.log(this.veterinarios);
        }, (error) => {
          console.log(error);
          Swal.fire('Error !!','Error al cargar los Veterinarios','error');
        }
      );
    }

    

    

    //this.reservaCita.mascota.id = this.login.getId();
  }

  formSubmit(){
    if(this.reservaCita.fecha.trim() == '' || this.reservaCita.fecha == null){
      this.snack.open("La fecha es requerida !!",'',{
        duration:3000
      })
      return ;
    }
    else if(this.reservaCita.hora.trim() == '' || this.reservaCita.hora == null){
      this.snack.open('La hora es requerida','',{
        duration:3000 });
      return;
    }

    this.reservaCitaService.agregarReservacita(this.reservaCita).subscribe(
      (dato:any) => {
        this.reservaCita.fecha = '';
        this.reservaCita.hora = '';
        this.reservaCita.mascota = {
          id : ''
        };
        this.reservaCita.veterinario = {
          id : ''
        };
        Swal.fire('Reserva Cita agregada','La Reserva Cita ha sido agregada con exito','success');
        if (this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN') {
          this.router.navigate(['/admin/reservacitas']);
        } else {
          this.router.navigate(['/user-dashboard/reservalogin', this.login.getId()]);
        }       
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al guardar la Reserva Cita','error')
      }
    )
  }

}
