import { Component, OnInit } from '@angular/core';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-especialidades',
  templateUrl: './view-especialidades.component.html',
  styleUrls: ['./view-especialidades.component.css']
})
export class ViewEspecialidadesComponent implements OnInit {

  especialidades:any = []

  especialidadesPorEstado: any[] = [];
  selectedEstado: boolean | null = null;

  constructor(private especialidadService:EspecialidadService) { }

  ngOnInit(): void {
    this.especialidadService.listarEspecialidades().subscribe(
      (dato:any) => {
        this.especialidades = dato;
        console.log(this.especialidades);       
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar las especialidades','error');
      }
    )
  }

  filtrarEspecialidadesPorEstado(): void {
    if (this.selectedEstado !== null) {
      this.especialidadService
        .listarEspecialidadesPorEstado(this.selectedEstado)
        .subscribe(
          (data: any) => {
            this.especialidadesPorEstado = data;
          },
          (error) => {
            console.log(error);
            Swal.fire(
              'Error !!',
              'Error al cargar las especialidades por estado',
              'error'
            );
          }
        );
    } else {
      this.especialidadesPorEstado = [];
    }
  }

  eliminarEsp(id:any){
    Swal.fire({
      title:'Eliminar Especialidad',
      text:'¿Estas seguro de eliminar esta Especialidad?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.especialidadService.eliminarEspecialidad(id).subscribe(
          (data) => {
            this.especialidades = this.especialidades.filter((especialidad:any) => especialidad.id != id );
            Swal.fire('Especialidad Eliminado','La especialidad ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar la especialidad','error');
          }
        )
      }
    })
  }

}
