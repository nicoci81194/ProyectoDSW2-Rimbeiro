import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RecetaService } from 'src/app/services/receta.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-recetas',
  templateUrl: './view-recetas.component.html',
  styleUrls: ['./view-recetas.component.css']
})

export class ViewRecetasComponent implements OnInit {

  recetas:any = [  
  ]

  constructor(private route: ActivatedRoute ,private recetaService : RecetaService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.recetaService.listarRecetaDeReserva(id).subscribe(
        (dato: any) => {
          this.recetas = dato;
          console.log(this.recetas);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las mascotas');
        }
      );
    });

    this.route.params.subscribe(params => {
      const id = params['id'];
      this.recetaService.listarDiagnosticoDeReceta(id).subscribe(
        (dato: any) => {
          this.recetas.diagnosticos = dato;
          console.log(this.recetas.diagnosticos);
        },
        (error) => {
          console.log(error);
          Swal.fire('Fatal Error !!', 'Error al cargar las mascotas');
        }
      );
    });

  }

}
