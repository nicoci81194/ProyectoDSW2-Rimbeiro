import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { MascotaService } from 'src/app/services/mascota.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-mascotas',
  templateUrl: './view-mascotas.component.html',
  styleUrls: ['./view-mascotas.component.css']
})
export class ViewMascotasComponent implements OnInit {

  mascotas:any = []

  mascotasPorEspecie: any[] = [];
  selectedEspecie: string | null = null;

  constructor(private mascotaService:MascotaService, public login:LoginService) { }

  ngOnInit(): void {
    this.mascotaService.listarMascotas().subscribe(
      (dato:any) => {
        this.mascotas = dato;
        console.log(this.mascotas);
      },
      (error) => {
        console.log(error);
        Swal.fire('Fatal Error !!','Error al cargar las mascotas')
      }
    )
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

  getProfileLink(rcId: string): string[] {
    if (this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN') {
      return ['/admin/reservacita-mascota', rcId];
    } else if (this.login.isLoggedIn() && this.login.getUserRole() == 'VETERINARIO') {
      return  ['/vet-dashboard/reservacita-mascota', rcId];
    } else {
      return ['/user-dashboard/reservacita-mascota', rcId];
    }
  }

}
