import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReservaCitaService } from 'src/app/services/reserva-cita.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-reservacitas-mascota',
  templateUrl: './view-reservacitas-mascota.component.html',
  styleUrls: ['./view-reservacitas-mascota.component.css']
})
export class ViewReservacitasMascotaComponent implements OnInit {

  reservacitas:any = [];
  constructor(private route: ActivatedRoute, private reservaCitaServicio: ReservaCitaService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const usuarioId = params['id'];
      this.reservaCitaServicio.listarReservaCitasDeMascota(usuarioId).subscribe(
        (dato: any) => {
          this.reservacitas = dato;
          console.log(this.reservacitas);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las mascotas');
        }
      );
    });
  }

}
