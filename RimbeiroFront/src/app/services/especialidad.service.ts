import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {

  constructor(private http:HttpClient) { }

  public listarEspecialidades(){
    return this.http.get(`${baserUrl}/rimbeiro/especialidades`);
  }

  public agregarEspecialidad(especialidad:any){
    return this.http.post(`${baserUrl}/rimbeiro/especialidad`,especialidad);
  }

  public eliminarEspecialidad(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/especialidad/${id}`);
  }

  public obtenerEspecialidad(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/especialidad/${id}`);
  }

  public actualizarEspecialidad(especialidad:any){
    return this.http.put(`${baserUrl}/rimbeiro/especialidad`,especialidad);
  }

  public listarEspecialidadesPorEstado(estado: boolean) {
    return this.http.get(`${baserUrl}/rimbeiro/especialidades?estado=${estado}`);
  }

}
