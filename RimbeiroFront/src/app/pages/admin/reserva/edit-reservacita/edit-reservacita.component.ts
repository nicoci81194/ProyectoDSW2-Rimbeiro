import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { MascotaService } from 'src/app/services/mascota.service';
import { ReservaCitaService } from 'src/app/services/reserva-cita.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-edit-reservacita',
  templateUrl: './edit-reservacita.component.html',
  styleUrls: ['./edit-reservacita.component.css']
})
export class EditReservacitaComponent implements OnInit {

  constructor(private router:ActivatedRoute,
    private snack:MatSnackBar,
    private reservaCitaService:ReservaCitaService,
    private veterinarioService:VeterinarioService,
    private mascotaService:MascotaService,
    private usuarioService:UsuarioService,
    public login:LoginService,
    private datePipe: DatePipe,
    private route:Router) { }

    id  = 0;
    reservacita:any;
    veterinarios:any;
    mascotas:any;

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.reservaCitaService.obtenerReservaCita(this.id).subscribe(
      (data) => {
        this.reservacita = data;
        this.reservacita.fecha = this.datePipe.transform(this.reservacita.fecha, 'yyyy-MM-dd');
        console.log(this.reservacita);
      },
      (error) => {
        console.log(error);
      }
    )
  
    this.veterinarioService.listarVeterinarios().subscribe(
      (data:any) => {
        this.veterinarios = data;
      },
      (error) => {
        alert('Error al cargar las veterinarios');
      }
    )

    this.mascotaService.listarMascotas().subscribe(
      (data:any) => {
        this.veterinarios = data;
      },
      (error) => {
        alert('Error al cargar las mascotas');
      }
    )

    this.mascotaService.listarMascotas().subscribe(
      (data:any) => {
        this.veterinarios = data;
      },
      (error) => {
        alert('Error al cargar las mascotas');
      }
    )
    
    
    this.usuarioService.listarMascotasDeUsuario(this.login.getId()).subscribe(
      (dato: any) => {
        this.mascotas = dato;
        console.log(this.mascotas);
      },
      (error) => {
        alert('Error al cargar el listarMascotasDeUsuario');
      }
    )


    }

    public actualizarDatosRC(){
      this.reservaCitaService.actualizarReservaCita(this.reservacita).subscribe(
        (data) => {
          Swal.fire('Reserva Cita actualizado','Se actualizo la Reserva Cita exitosamente','success').then(
            (e) => {
              this.route.navigate(['/admin/reservacita']);
            }
          );
        },
        (error) => {
          Swal.fire('Error en el sistema','No se pudo actualizar la Reserva Cita','error');
          console.log(error);
        }
      )
    }



  }
