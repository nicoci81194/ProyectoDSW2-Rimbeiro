import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-veterinario',
  templateUrl: './edit-veterinario.component.html',
  styleUrls: ['./edit-veterinario.component.css']
})
export class EditVeterinarioComponent implements OnInit {

  constructor(private router:ActivatedRoute,
    private veterinarioService:VeterinarioService,
    private especialidadService:EspecialidadService,
    private route:Router) { }

  id  = 0;
  veterinario:any;
  especialidades:any;

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.veterinarioService.obtenerVeterinario(this.id).subscribe(
      (data) => {
        this.veterinario = data;
        console.log(this.veterinario);
      },
      (error) => {
        console.log(error);
      }
    )

    this.especialidadService.listarEspecialidades().subscribe(
      (data:any) => {
        this.especialidades = data;
      },
      (error) => {
        alert('Error al cargar las especialidades');
      }
    )
  }

  public actualizarDatosV(){
    this.veterinarioService.actualizarVeterinario(this.veterinario).subscribe(
      (data) => {
        Swal.fire('Veterinario actualizado','Se actualizo el veterinario exitosamente','success').then(
          (e) => {
            this.route.navigate(['/admin/veterinarios']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se pudo actualizar el veterinario','error');
        console.log(error);
      }
    )
  }

}
