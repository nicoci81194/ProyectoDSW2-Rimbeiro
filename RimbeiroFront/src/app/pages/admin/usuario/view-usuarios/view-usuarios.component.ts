import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-usuarios',
  templateUrl: './view-usuarios.component.html',
  styleUrls: ['./view-usuarios.component.css']
})
export class ViewUsuariosComponent implements OnInit {

  usuarios: any = []

  constructor(private usuarioService:UsuarioService, private router:Router) { }

  ngOnInit(): void {
    this.usuarioService.listarUsuarios().subscribe(
      (dato:any) => {
        this.usuarios = dato;
        console.log(this.usuarios);       
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los usuarios','error');
      }
    )
  }

  desactivarUsuario(id:any){
    Swal.fire({
      title:'Desactivar Cuenta',
      text:'¿Estas seguro de desactivar esta cuenta?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Desactivar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.usuarioService.desactivarUsuario(id).subscribe(
          (data) => {
            this.usuarios = this.usuarios.filter((usuarios:any) => usuarios.id != id );
            Swal.fire('Usuario Desactivado','El usuario ha sido desactivado','success');
          },
          (error) => {
            Swal.fire('Error','Error al desactivar cuenta','error');
          }
        )
      }
    })
  }

  activarUsuario(id:any){
    Swal.fire({
      title:'Activar Cuenta',
      text:'¿Estas seguro de activar esta cuenta?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Activar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.usuarioService.activarUsuario(id).subscribe(
          (data) => {
            this.usuarios = this.usuarios.filter((usuarios:any) => usuarios.id != id );
            Swal.fire('Usuario Activado','El usuario ha sido activado','success');
          },
          (error) => {
            Swal.fire('Error','Error al activar cuenta','error');
          }
        )
      }
    })
  }
 
  eliminarUsuario(id:any){
    Swal.fire({
      title:'Eliminar Cuenta',
      text:'¿Estas seguro de eliminar esta cuenta?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonColor:'#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText:'Cancelar'
    }).then((result) => {
      if(result.isConfirmed){
        this.usuarioService.eliminarUsuario(id).subscribe(
          (data) => {
            this.usuarios = this.usuarios.filter((usuarios:any) => usuarios.id != id );
            Swal.fire('Usuario Elimina','El usuario ha sido eliminado','success');
          },
          (error) => {
            Swal.fire('Error','Error al eliminar esta cuenta','error');
          }
        )
      }
    })
  }

}
