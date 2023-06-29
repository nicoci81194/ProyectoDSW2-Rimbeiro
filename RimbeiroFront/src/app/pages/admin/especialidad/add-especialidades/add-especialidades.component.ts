import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-especialidades',
  templateUrl: './add-especialidades.component.html',
  styleUrls: ['./add-especialidades.component.css']
})
export class AddEspecialidadesComponent implements OnInit {

  especialidad = {
    descripcion : ''
  }

  constructor(private especialidadService:EspecialidadService, private snack:MatSnackBar, private router:Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if(this.especialidad.descripcion.trim() == '' || this.especialidad.descripcion == null ){
      this.snack.open("La necesaria una Descripcion !!", '',{
        duration: 3000
      })
      return;
    }

    this.especialidadService.agregarEspecialidad(this.especialidad).subscribe(
      (dato:any) => {
        this.especialidad.descripcion = '';
        Swal.fire('Especialidad agregada','La Especialidad se agrego exitosamente','success');
        this.router.navigate(['/admin/especialidades']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Errpr !!','Error al guardar la especialidad','error')
      }
    )

    
  }

}
