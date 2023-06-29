import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-usuario',
  templateUrl: './edit-usuario.component.html',
  styleUrls: ['./edit-usuario.component.css']
})
export class EditUsuarioComponent implements OnInit {

  constructor(
    private route:ActivatedRoute,
    private usuarioService:UsuarioService,
    private router:Router
  ) { }

    id = 0;
    usuarios:any;

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.usuarioService.obtenerUsuario(this.id).subscribe(
      (data) => {
        this.usuarios = data;
        console.log(this.usuarios);
      },
      (error) => {
        console.log(error);
      }
    )
  }

  actualizarDatosU(){
    this.usuarioService.actualizarUsuario(this.id, this.usuarios).subscribe(
      (data) => {
        Swal.fire('Usuario actualizada','Se actualizo la usuario exitosamente','success').then(
          (e) => {
            this.router.navigate(['/admin/usuarios']);
          }
        );
      },
      (error) => {
        Swal.fire('Error en el sistema','No se pudo actualizar el usuario','error');
        console.log(error);
      }
    )
  }

}
