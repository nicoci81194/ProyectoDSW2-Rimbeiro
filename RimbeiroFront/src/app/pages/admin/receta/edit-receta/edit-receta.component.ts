import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RecetaService } from 'src/app/services/receta.service';
import { ReservaCitaService } from 'src/app/services/reserva-cita.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-receta',
  templateUrl: './edit-receta.component.html',
  styleUrls: ['./edit-receta.component.css']
})
export class EditRecetaComponent implements OnInit {

  constructor(private router:ActivatedRoute,
    private recetaService:RecetaService,
    private veterinarioService:VeterinarioService,
    private reservaCitaService:ReservaCitaService,
    private route:Router) { }

  id = 0;
  receta:any;
  reservacitas:any;

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.recetaService.obtenerReceta(this.id).subscribe(
      (data) => {
        this.receta = data;
        console.log(this.receta);
      },
      (error) => {
        console.log(error);
      }
    )

    this.reservaCitaService.listarReservacitas().subscribe(
      (data:any) => {
        this.reservacitas = data;
      },
      (error) => {
        alert('Error al cargar las listarReservacitas');
      }
    )
  }

  public actualizarDatosR(){
    this.recetaService.actualizarReceta(this.receta).subscribe(
      (data) => {
        Swal.fire('Receta actualizado','Se actualizo la Receta exitosamente','success').then(
          (e) => {
            this.route.navigate(['/admin/reservacitas']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se pudo actualizar las Recetas','error');
        console.log(error);
      }
    )
  }

}
