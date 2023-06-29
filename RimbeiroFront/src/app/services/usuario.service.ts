import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { }

  public listarUsuarios(){
    return this.http.get(`${baserUrl}/rimbeiro/usuarios`);
  }

   //

   /*public agregarUsuario(usuario:any , rolId:number){
    const body = {
      usuario: usuario,
      rolId: rolId
    };
    console.log('Cuerpo de la solicitud:', JSON.stringify(body, null, 2));
    return this.http.post(`${baserUrl}/rimbeiro/usuario`,body);
  }*/

  public agregarUsuario(usuario: any, rolId: number) {
    const body = {
      username: usuario.username,
      password: usuario.password,
      nombre: usuario.nombre,
      apellido: usuario.apellido,
      email: usuario.email,
      telefono: usuario.telefono
    };
    console.log('Cuerpo de la solicitud:', JSON.stringify(body, null, 2));
    return this.http.post(`${baserUrl}/rimbeiro/usuario?rolId=${rolId}`, body);
  }

  //

  public eliminarUsuario(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/usuario/${id}`);
  }

  public desactivarUsuario(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/usuarioInactivo/${id}`);
  }

  public activarUsuario(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/usuarioActivo/${id}`);
  }

  public obtenerUsuario(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/usuariosid/${id}`);
  }

  public actualizarUsuario(id: number,usuario:any){
    return this.http.put(`${baserUrl}/rimbeiro/usuario/${id}`,usuario);
  }

  public listarMascotasDeUsuario(id: any) {
    return this.http.get(`${baserUrl}/rimbeiro/usuariomascota/${id}`);
  }

  //

  public listarRolesDeUsuario(){
    return this.http.get(`${baserUrl}/rimbeiro/roles`);
  }
}
 /*public agregarUsuario(usuario:any){
    return this.http.post(`${baserUrl}/rimbeiro/usuario`,usuario);
  }*/

    /*public agregarUsuario(usuario:any , rolId:number[]){
    const body = {
      usuario: usuario,
      rolId: rolId.join(',')
    };
    return this.http.post(`${baserUrl}/rimbeiro/usuario`,body);
  }*/