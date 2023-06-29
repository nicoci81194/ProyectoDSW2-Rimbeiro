import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { ReservaCitaService } from 'src/app/services/reserva-cita.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-reservalogin',
  templateUrl: './view-reservalogin.component.html',
  styleUrls: ['./view-reservalogin.component.css']
})
export class ViewReservaloginComponent implements OnInit {

  reservacitas:any = []

  reservasPorDia: any[] = [];
  selectedDia: Date | null = null;

  constructor(
    private route: ActivatedRoute, 
    private reservaService: ReservaCitaService,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    const usuarioId = this.loginService.getUser()?.id; // Obtiene el ID del usuario logueado
    if (usuarioId) {
      this.reservaService.listarReservaCitasDeUsuario(usuarioId).subscribe(
        (dato: any) => {
          this.reservacitas = dato;
          console.log(this.reservacitas);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las reservas citas');
        }
      );
    } else {
      // Manejo de caso en el que no se encuentra el ID del usuario logueado
      // Puedes redirigir a otra página, mostrar un mensaje de error, etc.
    }
  }

  filtrarHorariosPorDia() {
    if (this.selectedDia !== null) {
      this.reservaService.listarReservasCitaPorDia(this.selectedDia).subscribe(
        (data: any) => {
          this.reservasPorDia = data;
        },
        (error) => {
          console.log(error);
          Swal.fire('Error !!', 'Error al cargar los horarios por día de la semana', 'error');
        }
      );
    }
  }

}
