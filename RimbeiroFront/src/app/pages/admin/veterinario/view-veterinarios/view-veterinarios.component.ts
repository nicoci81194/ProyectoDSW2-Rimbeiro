import { Component, OnInit } from '@angular/core';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-veterinarios',
  templateUrl: './view-veterinarios.component.html',
  styleUrls: ['./view-veterinarios.component.css']
})
export class ViewVeterinariosComponent implements OnInit {
  selectedEspecialidad: number | null = null;
  veterinariosPorEspecialidad: any[] = [];
  especialidades:any=[];
  filtrarPorEspecialidad: boolean = false;
  
  veterinarios:any = []
  
  constructor(private veterinarioService:VeterinarioService,
    private especialidadService:EspecialidadService) { }

  ngOnInit(): void {
    this.veterinarioService.listarVeterinarios().subscribe(
      (dato:any) => {
        this.veterinarios = dato;
        console.log(this.veterinarios);       
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los veterinarios','error');
      }
    )
    //
    this.especialidadService.listarEspecialidades().subscribe(
      (data: any) => {
        this.especialidades = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar las especialidades','error');
      }
    );
  }

  filtrarVeterinariosPorEspecialidad() {
    if (this.selectedEspecialidad !== null) {
      this.filtrarPorEspecialidad = true;
      this.veterinarioService.listarVeterinariosPorEspecialidad(this.selectedEspecialidad).subscribe(
        (data: any) => {
          this.veterinariosPorEspecialidad = data;
        },
        (error) => {
          console.log(error);
          Swal.fire('Error !!', 'Error al cargar los veterinarios por especialidad', 'error');
        }
      );
    } else {
      this.filtrarPorEspecialidad = false;
    }
  }

  eliminarVet(id:any){
    Swal.fire({
      title:'Eliminar Veterinario',
      text:'¿Estas seguro de eliminar este Veterinario?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.veterinarioService.eliminarVeterinario(id).subscribe(
          (data) => {
            this.veterinarios = this.veterinarios.filter((veterinario:any) => veterinario.id != id );
            Swal.fire('Veterinario Eliminado','El Veterinario ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar el Veterinario','error');
          }
        )
      }
    })
  }

}
