import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { MascotaService } from 'src/app/services/mascota.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-mascota',
  templateUrl: './edit-mascota.component.html',
  styleUrls: ['./edit-mascota.component.css']
})
export class EditMascotaComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private mascotaService:MascotaService,
    private usuarioService:UsuarioService,
    private router:Router,
    private login:LoginService) { }

    id = 0;
    mascota:any;
    usuarios:any;

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.mascotaService.obtenerMascota(this.id).subscribe(
      (data) => {
        this.mascota = data;
        console.log(this.mascota);
      },
      (error) => {
        console.log(error);
      }
    )
    this.usuarioService.listarUsuarios().subscribe(
      (data:any) => {
        this.usuarios = data;
      },(error)=> {
        alert('Error al cargar las especialidades');
      }
    )
  }

  public actualizarDatosM(){
    this.mascotaService.actualizarMascota(this.mascota).subscribe(
      (data) => {
        Swal.fire('Mascota actualizada','Se actualizo la mascota exitosamente','success').then(
          (e) => {
            //this.router.navigate(['/admin/mascotas']);
            if (this.login.isLoggedIn() && this.login.getUserRole() == 'ADMIN') {
              this.router.navigate(['/admin/mascotas']);
            } else {
              this.router.navigate(['/user-dashboard/mascotalogin', this.login.getId()]);
            }
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se pudo actualizar la mascota','error');
        console.log(error);
      }
    )
  }

  especiePermitida(especie: string): boolean {
    const especiesPermitidas = ['perro', 'gato', 'conejo', 'loro', 'perico', 'hamster', 'huron', 'otro'];
    return especiesPermitidas.includes(especie);
  }
}
