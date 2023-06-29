import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class VeterinarioService {

  constructor(private http:HttpClient) { }

  public listarVeterinarios(){
    return this.http.get(`${baserUrl}/rimbeiro/veterinarios`);
  }

  public agregarVeterinario(veterinario:any){
    return this.http.post(`${baserUrl}/rimbeiro/veterinario`,veterinario);
  }

  public eliminarVeterinario(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/veterinario/${id}`);
  }

  public obtenerVeterinario(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/veterinario/${id}`);
  }

  public actualizarVeterinario(veterinario:any){
    return this.http.put(`${baserUrl}/rimbeiro/veterinario`,veterinario);
  }

  //

  public listarVeterinariosPorEspecialidad(idEspecialidad: number) {
    return this.http.get(`${baserUrl}/rimbeiro/veterinarios?idEspecialidad=${idEspecialidad}`);
  }

}
