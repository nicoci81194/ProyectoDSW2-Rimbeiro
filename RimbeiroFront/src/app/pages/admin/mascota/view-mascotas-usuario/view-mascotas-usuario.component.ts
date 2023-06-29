import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-mascotas-usuario',
  templateUrl: './view-mascotas-usuario.component.html',
  styleUrls: ['./view-mascotas-usuario.component.css']
})
export class ViewMascotasUsuarioComponent implements OnInit {

  mascotas: any = [];
  constructor(private route: ActivatedRoute, private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const usuarioId = params['id'];
      this.usuarioService.listarMascotasDeUsuario(usuarioId).subscribe(
        (dato: any) => {
          this.mascotas = dato;
          console.log(this.mascotas);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las mascotas');
        }
      );
    });
  }
}
