import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class HorarioService {

  constructor(private http:HttpClient) { }

  public listarHorarios(){
    return this.http.get(`${baserUrl}/rimbeiro/horarios`);
  }

  public agregarHorario(horario:any){
    return this.http.post(`${baserUrl}/rimbeiro/horario`,horario);
  }

  public eliminarHorario(id:any){
    return this.http.delete(`${baserUrl}/rimbeiro/horario/${id}`);
  }

  public obtenerHorario(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/horario/${id}`);
  }

  public actualizarHorario(horario:any){
    return this.http.put(`${baserUrl}/rimbeiro/horario`,horario);
  }

  public listarHorariosPorDia(dia: string) {
    return this.http.get(`${baserUrl}/rimbeiro/horarios?dia=${dia}`);
  }

}
