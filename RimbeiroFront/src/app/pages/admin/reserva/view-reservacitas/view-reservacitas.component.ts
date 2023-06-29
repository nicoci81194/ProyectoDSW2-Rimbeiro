import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { ReservaCitaService } from 'src/app/services/reserva-cita.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-reservacitas',
  templateUrl: './view-reservacitas.component.html',
  styleUrls: ['./view-reservacitas.component.css']
})
export class ViewReservacitasComponent implements OnInit {
  reservacitas:any = []

  reservasPorDia: any[] = [];
  selectedDia: Date | null = null;

  
  constructor(private reservaCitaService:ReservaCitaService, 
    public login:LoginService, 
    private router:Router) { }

  ngOnInit(): void {
    this.reservaCitaService.listarReservacitas().subscribe(
      (dato:any) => {
        this.reservacitas = dato;
        console.log(this.reservacitas);
      }, (error) => {
        console.log(error);
        Swal.fire('Error!!','Error al cargar las Reservas Citas','error');
      }
    )
  }

  filtrarHorariosPorDia() {
    if (this.selectedDia !== null) {
      this.reservaCitaService.listarReservasCitaPorDia(this.selectedDia).subscribe(
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

  getProfileLink(rcId: string): string[] {
    if (this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN') {
      return ['/admin/receta', rcId];
    } else if (this.login.isLoggedIn() && this.login.getUserRole() == 'VETERINARIO') {
      return  ['/vet-dashboard/receta', rcId];
    } else {
      return ['/user-dashboard/receta', rcId];
    }
  }

  seleccionarReserva(reservaId: any) {
    this.router.navigate(['/agregar-receta', reservaId]);
  }

  eliminarReservacitas(id:any){
    Swal.fire({
      title:'Eliminar Reserva citas',
      text:'¿Estas seguro de eliminar la Reserva Cita?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Eliminar',
      cancelButtonText: 'Cancelar'

    }).then((result) => {
      if(result.isConfirmed){
        this.reservaCitaService.eliminarReservaCita(id).subscribe(
          (data) => {
            this.reservacitas = this.reservacitas.filter((reservacitas:any) => reservacitas.id != id);
            Swal.fire('Reserva Cita Eliminado SEBASTIAN','La Reserva Cita ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar La Reserva Cita','error');
          }
        )
      }
    })

  }
}
