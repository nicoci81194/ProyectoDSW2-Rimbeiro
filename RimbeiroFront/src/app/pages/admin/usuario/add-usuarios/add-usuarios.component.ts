import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-usuarios',
  templateUrl: './add-usuarios.component.html',
  styleUrls: ['./add-usuarios.component.css']
})
export class AddUsuariosComponent implements OnInit {

  roles : any = [];

  usuarios: any = {
    username : '',
    password : '',
    nombre : '',
    apellido : '',
    email : '',
    telefono : '',
    roles: {
      id:''
    }
  };

  selectedRolId: number = 0;

  constructor(private snack:MatSnackBar,
    private router:Router,
    private usuarioService:UsuarioService) { }

  ngOnInit(): void {
    this.usuarioService.listarRolesDeUsuario().subscribe(
      (dato:any) => {
        this.roles = dato;
        console.log(this.roles);
      }, (error) => {
        console.log(error);
        Swal.fire('Error !!','Error al cargar los datos de rol','error');
      }
    )
  }

  guardarUsuario() {
    if (this.selectedRolId === 0) {
      this.snack.open('Debes seleccionar un rol', '', { duration: 3000 });
      return;
    }
    if(this.usuarios.username.trim() == '' || this.usuarios.username == null){
      this.snack.open('El Nombre de Usuario es requerido','',{
        duration:3000
      });
      return;
    }
    if(this.usuarios.password.trim() == '' || this.usuarios.password == null){
      this.snack.open('La Contraseña es requerida','',{
        duration:3000
      });
      return;
    }
    if(this.usuarios.nombre.trim() == '' || this.usuarios.nombre == null){
      this.snack.open('El Nombre es requerido','',{
        duration:3000
      });
      return;
    }
    if(this.usuarios.apellido.trim() == '' || this.usuarios.apellido == null){
      this.snack.open('El Apellido es requerido','',{
        duration:3000
      });
      return;
    }
    if(this.usuarios.email.trim() == '' || this.usuarios.email == null){
      this.snack.open('El Email es requerido','',{
        duration:3000
      });
      return;
    }
    else if(this.usuarios.telefono.trim() == '' || this.usuarios.telefono == null){
      this.snack.open('El telefono es requerido','',{
        duration:3000
      });
      return;
    }

    this.usuarioService.agregarUsuario(this.usuarios,this.selectedRolId).subscribe(
      (data) => {
        console.log(data);
        Swal.fire('Usuario guardado', 'El Usuario se guardó correctamente', 'success');
        this.usuarios = {
          username: '',
          password: '',
          nombre: '',
          apellido: '',
          email: '',
          telefono: ''
        };
        this.router.navigate(['/admin/usuarios']);
      },
      (error) => {
        Swal.fire('Error', 'Error al guardar el Usuario', 'error');
      }
    );
  }

}
/*
console.log(this.usuarios);
    
*/