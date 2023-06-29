import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HorarioService } from 'src/app/services/horario.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-horario',
  templateUrl: './edit-horario.component.html',
  styleUrls: ['./edit-horario.component.css']
})
export class EditHorarioComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private horarioService:HorarioService,
    private veterinarioService:VeterinarioService,
    private router:Router) { }

  id  = 0;
  horario:any;
  veterinarios:any;

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.horarioService.obtenerHorario(this.id).subscribe(
      (data) => {
        this.horario = data;
        console.log(this.horario);
      },
      (error) => {
        console.log(error);
      }
    )

    this.veterinarioService.listarVeterinarios().subscribe(
      (data:any) => {
        this.veterinarios = data;
      },
      (error) => {
        alert('Error al cargar los veterinarios');
      }
    )
  }

  public actualizarDatosH(){
    this.horarioService.actualizarHorario(this.horario).subscribe(
      (data) => {
        Swal.fire('Horario actualizado','Se actualizo el horario exitosamente','success').then(
          (e) => {
            this.router.navigate(['/admin/horarios']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se pudo actualizar el horario','error');
        console.log(error);
      }
    )
  }

}
