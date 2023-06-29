import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-veterinarios',
  templateUrl: './add-veterinarios.component.html',
  styleUrls: ['./add-veterinarios.component.css']
})
export class AddVeterinariosComponent implements OnInit {


  especialidades:any=[];

  veterinario = {
    nombres : '',
    apellidoPaterno: '',
    apellidoMaterno: '',
    especialidad:{
      id : ''
    }
  }

  constructor(private especialidadService:EspecialidadService, 
    private snack:MatSnackBar,
    private veterinarioService:VeterinarioService, 
    private router:Router) { }

  ngOnInit(): void {
    this.especialidadService.listarEspecialidades().subscribe(
      (dato:any) => {
        this.especialidades = dato;
        console.log(this.especialidades);
      }, (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los datos','error');
      }
    )
  }

  guardarVeterinario(){
    console.log(this.veterinario);
    if(this.veterinario.nombres.trim() == '' || this.veterinario.nombres == null){
      this.snack.open('El Nombre es requerido','',{
        duration:3000 });
      return;
    }
    else if(this.veterinario.apellidoPaterno.trim() == '' || this.veterinario.apellidoPaterno == null){
      this.snack.open('Es necesario colocar tu Apellido Paterno','',{
        duration:3000 });
      return;
    }
    else if(this.veterinario.apellidoMaterno.trim() == '' || this.veterinario.apellidoMaterno == null){
      this.snack.open('Es necesario colocar tu Apellido Materno','',{
        duration:3000 });
      return;
    }

this.veterinarioService.agregarVeterinario(this.veterinario).subscribe(
  (data) => {
    console.log(data);
    Swal.fire('Veterinario guardado','El Veterinario se guardo correctamente','success');
    this.veterinario = {
      nombres : '',
    apellidoPaterno: '',
    apellidoMaterno: '',
    especialidad:{
      id : ''
    }
    }
    this.router.navigate(['/admin/add-veterinario']);
    this.router.navigate(['/admin/veterinarios']);
  },

  (error) => {
    Swal.fire('Error','Error al guardar el Veterinario','error');
  }
)

  }

}
