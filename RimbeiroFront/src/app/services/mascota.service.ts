import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class MascotaService {

  constructor(private http:HttpClient) { }

  public listarMascotas(){
    return this.http.get(`${baserUrl}/rimbeiro/mascotas`);
  }

  public listarMascotasPorEspecie(especie: string) {
    return this.http.get(`${baserUrl}/rimbeiro/mascotasEspecie/${especie}`);
  }

  public agregarMascota(mascota:any){
    return this.http.post(`${baserUrl}/rimbeiro/mascota`,mascota);
  }

  public eliminarMascota(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/mascota/${id}`);
  }

  public obtenerMascota(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/mascota/${id}`);
  }

  public actualizarMascota(mascota:any){
    return this.http.put(`${baserUrl}/rimbeiro/mascota`,mascota);
  }

}
