import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { MascotaService } from 'src/app/services/mascota.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-view-mascotalogin',
  templateUrl: './view-mascotalogin.component.html',
  styleUrls: ['./view-mascotalogin.component.css']
})
export class ViewMascotaloginComponent implements OnInit {

  mascotas:any = [];

  mascotasPorEspecie: any[] = [];
  selectedEspecie: string | null = null;

  constructor(
    private route: ActivatedRoute, 
    private usuarioService: UsuarioService,
    private loginService: LoginService,
    private mascotaService: MascotaService,
  ) { }

  ngOnInit(): void {
    const usuarioId = this.loginService.getUser()?.id; // Obtiene el ID del usuario logueado
    if (usuarioId) {
      this.usuarioService.listarMascotasDeUsuario(usuarioId).subscribe(
        (dato: any) => {
          this.mascotas = dato;
          console.log(this.mascotas);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las mascotas');
        }
      );
    } else {
      // Manejo de caso en el que no se encuentra el ID del usuario logueado
      // Puedes redirigir a otra página, mostrar un mensaje de error, etc.
    }
  }

  filtrarMascotasPorEspecie() {
    if (this.selectedEspecie !== null) {
      this.mascotaService.listarMascotasPorEspecie(this.selectedEspecie).subscribe(
        (data: any) => {
          this.mascotasPorEspecie = data;
        },
        (error) => {
          console.log(error);
          Swal.fire('Error !!', 'Error al cargar las mascotas', 'error');
        }
      );
    }
  }

  eliminarMas(id:any){
    Swal.fire({
      title:'Eliminar Mascota',
      text:'¿Estas seguro de eliminar esta Mascota?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.mascotaService.eliminarMascota(id).subscribe(
          (data) => {
            this.mascotas = this.mascotas.filter((mascota:any) => mascota.id != id );
            Swal.fire('Mascota Eliminado','La mascota ha sido eliminado de la base de datos','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar Mascota','error');
          }
        )
      }
    })
  }
}
