import { Injectable } from '@angular/core';
import baserUrl from './helper';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservaCitaService {

  constructor(private http:HttpClient) { }

  public listarReservacitas(){
    return this.http.get(`${baserUrl}/rimbeiro/reservas`);
  }

  public agregarReservacita(reservacitas:any){
    return this.http.post(`${baserUrl}/rimbeiro/reserva`, reservacitas);
  }

  public listarReservaCitasDeMascota(id: any) {
    return this.http.get(`${baserUrl}/rimbeiro/reservasMascota/${id}`);
  }

  public listarReservaCitasDeUsuario(id: any) {
    return this.http.get(`${baserUrl}/rimbeiro/reservaUsuario/${id}`);
  }

  public listarReservaCitaPorId(id: any){
    return this.http.get(`${baserUrl}/rimbeiro/reserva/${id}`);
  }

  public listarReservasCitaPorDia(fecha:Date){
    const formattedFecha = fecha.toISOString();
    return this.http.get(`${baserUrl}/rimbeiro/reservaDia?fecha=${formattedFecha}`);
  }

  public obtenerReservaCita(id:any){
    return this.http.get(`${baserUrl}/rimbeiro/reserva/${id}`);
  }

  public actualizarReservaCita(reservacita:any){
    return this.http.put(`${baserUrl}/rimbeiro/reserva`, reservacita);
  }

  public eliminarReservaCita(id: any){
    return this.http.delete(`${baserUrl}/rimbeiro/reserva/${id}`); 
  }

}
