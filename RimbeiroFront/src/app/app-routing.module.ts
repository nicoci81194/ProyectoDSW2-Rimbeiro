import { NormalGuard } from './services/normal.guard';
import { AdminGuard } from './services/admin.guard';
import { VetGuard } from './services/vet.guard';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { HomeComponent } from './pages/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VetDashboardComponent } from './pages/vet/vet-dashboard/vet-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import { ViewEspecialidadesComponent } from './pages/admin/especialidad/view-especialidades/view-especialidades.component';
import { ViewVeterinariosComponent } from './pages/admin/veterinario/view-veterinarios/view-veterinarios.component';
import { ViewHorariosComponent } from './pages/admin/horario/view-horarios/view-horarios.component';
import { AddEspecialidadesComponent } from './pages/admin/especialidad/add-especialidades/add-especialidades.component';
import { AddVeterinariosComponent } from './pages/admin/veterinario/add-veterinarios/add-veterinarios.component';
import { AddHorariosComponent } from './pages/admin/horario/add-horarios/add-horarios.component';
import { EditHorarioComponent } from './pages/admin/horario/edit-horario/edit-horario.component';
import { EditEspecialidadComponent } from './pages/admin/especialidad/edit-especialidad/edit-especialidad.component';
import { EditVeterinarioComponent } from './pages/admin/veterinario/edit-veterinario/edit-veterinario.component';
import { AddMascotasComponent } from './pages/admin/mascota/add-mascotas/add-mascotas.component';
import { EditMascotaComponent } from './pages/admin/mascota/edit-mascota/edit-mascota.component';
import { ViewMascotasComponent } from './pages/admin/mascota/view-mascotas/view-mascotas.component';
import { ViewUsuariosComponent } from './pages/admin/usuario/view-usuarios/view-usuarios.component';
import { EditUsuarioComponent } from './pages/admin/usuario/edit-usuario/edit-usuario.component';
import { ViewRecetasComponent } from './pages/admin/receta/view-recetas/view-recetas.component';
import { ViewReservacitasComponent } from './pages/admin/reserva/view-reservacitas/view-reservacitas.component';
import { AddRecetaComponent } from './pages/admin/receta/add-receta/add-receta.component';
import { AddReservacitaComponent } from './pages/admin/reserva/add-reservacita/add-reservacita.component';
import { ViewMascotasUsuarioComponent } from './pages/admin/mascota/view-mascotas-usuario/view-mascotas-usuario.component';
import { AddUsuariosComponent } from './pages/admin/usuario/add-usuarios/add-usuarios.component';
import { ViewReservacitasMascotaComponent } from './pages/admin/reserva/view-reservacitas-mascota/view-reservacitas-mascota.component';
import { ViewMascotaloginComponent } from './pages/user/view-mascotalogin/view-mascotalogin.component';
import { ViewReservaloginComponent } from './pages/user/view-reservalogin/view-reservalogin.component';
import { EditRecetaComponent } from './pages/admin/receta/edit-receta/edit-receta.component';
import { EditReservacitaComponent } from './pages/admin/reserva/edit-reservacita/edit-reservacita.component';

const routes: Routes = [
  {
    path : '',
    component : HomeComponent,
    pathMatch : 'full'
  },
  {
    path : 'signup',
    component : SignupComponent,
    pathMatch : 'full'
  },
  {
    path : 'login',
    component : LoginComponent,
    pathMatch : 'full'
  },
  {
    path:'admin',
    component:DashboardComponent,
    //pathMatch:'full',
    canActivate:[AdminGuard],
    children:[
      {path:'profile', component:ProfileComponent},
      {path:'', component:WelcomeComponent},
      {path:'especialidades', component:ViewEspecialidadesComponent },
      {path:'veterinarios', component:ViewVeterinariosComponent},
      {path:'horarios', component:ViewHorariosComponent},
      {path:'mascotas', component: ViewMascotasComponent},
      {path:'usuarios', component:ViewUsuariosComponent},
      {path:'add-especialidad', component:AddEspecialidadesComponent},
      {path:'add-mascota', component:AddMascotasComponent},
      {path:'add-veterinario', component:AddVeterinariosComponent},
      {path:'add-horario', component:AddHorariosComponent},
      {path:'add-usuario', component:AddUsuariosComponent},
      {path:'horario/:id', component:EditHorarioComponent},
      {path:'especialidad/:id', component:EditEspecialidadComponent},
      {path:'mascota/:id', component:EditMascotaComponent},
      {path:'usuario/:id', component:EditUsuarioComponent},
      {path:'veterinario/:id', component:EditVeterinarioComponent},
      {path:'receta/:id', component:ViewRecetasComponent },
      {path:'reservacitas', component:ViewReservacitasComponent },
      {path:'add-receta', component:AddRecetaComponent},
      {path:'add-reservacita', component:AddReservacitaComponent},
      {path:'mascota-usuario/:id', component:ViewMascotasUsuarioComponent},
      {path:'reservacita-mascota/:id', component:ViewReservacitasMascotaComponent},
      {path:'reservacita/:id', component:EditReservacitaComponent},
      {path:'edit-receta/:id', component:EditRecetaComponent}
    ]
  },
  {
    path:'user-dashboard',
    component:UserDashboardComponent,
    //pathMatch:'full',
    canActivate:[NormalGuard],
    children:[
      {path:'profile', component:ProfileComponent},
      {path:'', component:WelcomeComponent},
      {path:'add-mascota', component:AddMascotasComponent},
      {path:'mascotalogin/:id', component:ViewMascotaloginComponent},
      {path:'mascota/:id', component:EditMascotaComponent},
      {path:'reservalogin/:id', component:ViewReservaloginComponent},
      {path:'receta/:id', component:ViewRecetasComponent },
      {path:'reservacita-mascota/:id', component:ViewReservacitasMascotaComponent},
      {path:'add-reservacita', component:AddReservacitaComponent}
    ]
  },
  {
    path:'vet-dashboard',
    component:VetDashboardComponent,
    //pathMatch:'full',
    canActivate:[VetGuard],
    children:[
      {path:'profile', component:ProfileComponent},
      {path:'', component:WelcomeComponent},
      {path:'mascotas', component: ViewMascotasComponent},
      {path:'reservacitas', component:ViewReservacitasComponent },
      {path:'horarios', component:ViewHorariosComponent},
      {path:'receta/:id', component:ViewRecetasComponent },
      {path:'reservacita-mascota/:id', component:ViewReservacitasMascotaComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
