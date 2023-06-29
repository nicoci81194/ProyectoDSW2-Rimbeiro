import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { RecetaService } from 'src/app/services/receta.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-receta',
  templateUrl: './add-receta.component.html',
  styleUrls: ['./add-receta.component.css']
})
export class AddRecetaComponent implements OnInit {

  reservaCitas:any = [];

  receta = {
    reservaCita:{
      id : ''
    },
    diagnostico : '',
    indicaciones : '',
  }

  constructor(
    private recetaService:RecetaService, 
    private snack:MatSnackBar, 
    private router:Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if(this.receta.diagnostico.trim() == '' || this.receta.diagnostico == null){
      this.snack.open("El diagnostico es requerido !!",'',{
        duration:3000
      })
      return ;
    }
    

    this.recetaService.agregarReceta(this.receta).subscribe(
      (dato:any) => {
        this.receta.diagnostico = '';
        this.receta.indicaciones = '';
        this.receta.reservaCita = {
          id : ''
        };
         Swal.fire('Receta agregada','La Receta ha sido agregada con exito','success');
         this.router.navigate(['/admin/reservacitas']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al guardar la Receta','error')
      }
    )
  }
  
}
