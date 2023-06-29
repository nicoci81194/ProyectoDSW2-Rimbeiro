import { Injectable } from '@angular/core';
import baserUrl from './helper';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecetaService {

  constructor(private http:HttpClient) { }

  public listarRecetas(){
    return this.http.get(`${baserUrl}/rimbeiro/recetas`);
  }

  public agregarReceta(receta:any){
    return this.http.post(`${baserUrl}/rimbeiro/receta`, receta);
  }

  public agregarDiagnostico(diagnosticoReceta:any){
    return this.http.post(`${baserUrl}/rimbeiro/diagnostico`, diagnosticoReceta);
  }

  public listarRecetaDeReserva(id: any) {
    return this.http.get(`${baserUrl}/rimbeiro/recetaReserva/${id}`);
  }

  public listarDiagnosticoDeReceta(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/diagnosticoReceta/${id}`);
  }

  public obtenerReceta(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/receta/${id}`);
  }

  public actualizarReceta(receta:any){
    return this.http.put(`${baserUrl}/rimbeiro/receta`, receta);
  }
}
