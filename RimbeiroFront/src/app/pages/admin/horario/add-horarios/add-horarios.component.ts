import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { HorarioService } from 'src/app/services/horario.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-horarios',
  templateUrl: './add-horarios.component.html',
  styleUrls: ['./add-horarios.component.css']
})
export class AddHorariosComponent implements OnInit {

  veterinarios:any=[];

  horario = {
    diaSemana : '',
    horaInicio : '',
    horaFin: '',
    veterinario:{
      id : ''
    }
  }

  constructor(private veterinarioService:VeterinarioService,
    private snack: MatSnackBar,
    private horarioService: HorarioService,
    private router: Router) { }

  ngOnInit(): void {
    this.veterinarioService.listarVeterinarios().subscribe(
      (dato:any) => {
        this.veterinarios = dato;
        console.log(this.veterinarios);
      }, (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los datos','error');
      }
    )
  }

  guardarHorario(){
    console.log(this.horario);
    if(this.horario.diaSemana.trim() == '' || this.horario.diaSemana == null){
      this.snack.open('El Dia es requerido','',{
        duration:3000
      });
      return;
    }
    else if(this.horario.horaInicio.trim() == '' || this.horario.horaInicio == null){
      this.snack.open('La hora de Entreda es requerida','',{
        duration:3000
      });
      return;
    }
    else if(this.horario.horaFin.trim() == '' || this.horario.horaFin == null){
      this.snack.open('La hora de Salida es requerido','',{
        duration:3000
      });
      return;
    }

this.horarioService.agregarHorario(this.horario).subscribe(
  (data) => {
    console.log(data);
    Swal.fire('Horario guardado','El Horario se guardo correctamente','success');
    this.horario = {
      diaSemana : '',
    horaInicio : '',
    horaFin: '',
    veterinario:{
      id : ''
    }
    }
    this.router.navigate(['/admin/add-horario']);
    this.router.navigate(['/admin/horarios']);
  },

  (error) => {
    Swal.fire('Error','Error al guardar el Horario','error');
  }
)

  }

}
