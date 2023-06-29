import { Component, OnInit } from '@angular/core';
import { HorarioService } from 'src/app/services/horario.service';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-horarios',
  templateUrl: './view-horarios.component.html',
  styleUrls: ['./view-horarios.component.css']
})
export class ViewHorariosComponent implements OnInit {
//*ngFor= "let h of horarios"
  horarios:any = []

  horariosPorDia: any[] = [];
  selectedDia: string | null = null;

  constructor(
    private horarioService:HorarioService,
    public login:LoginService) { }

  ngOnInit(): void {
    this.horarioService.listarHorarios().subscribe(
      (dato:any) => {
        this.horarios = dato;
        console.log(this.horarios);       
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los horarios','error');
      }
    )
  }

  filtrarHorariosPorDia() {
    if (this.selectedDia !== null) {
      this.horarioService.listarHorariosPorDia(this.selectedDia).subscribe(
        (data: any) => {
          this.horariosPorDia = data;
        },
        (error) => {
          console.log(error);
          Swal.fire('Error !!', 'Error al cargar los horarios por día de la semana', 'error');
        }
      );
    }
  }

  eliminarHor(id:any){
    Swal.fire({
      title:'Eliminar Horario',
      text:'¿Estas seguro de eliminar este Horario?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.horarioService.eliminarHorario(id).subscribe(
          (data) => {
            this.horarios = this.horarios.filter((horario:any) => horario.id != id );
            Swal.fire('Horario Eliminado','El horario ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar este Horario','error');
          }
        )
      }
    })
  }

}
