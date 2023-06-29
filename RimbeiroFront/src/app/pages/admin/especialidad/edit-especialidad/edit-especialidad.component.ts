import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-especialidad',
  templateUrl: './edit-especialidad.component.html',
  styleUrls: ['./edit-especialidad.component.css']
})
export class EditEspecialidadComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private especialidadService:EspecialidadService,
    private router:Router) { }

    id  = 0;
    especialidad:any;

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.especialidadService.obtenerEspecialidad(this.id).subscribe(
      (data) => {
        this.especialidad= data;
        console.log(this.especialidad);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  public actualizarDatosE(){
    this.especialidadService.actualizarEspecialidad(this.especialidad).subscribe(
      (data) => {
        Swal.fire('Especialidad actualizada','Se actualizo la especialidad exitosamente','success').then(
          (e) => {
            this.router.navigate(['/admin/especialidades']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se pudo actualizar la especialidad','error');
        console.log(error);
      }
    )
  }

}
