import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';

//IMPORTACAIONES DE ANGULAR MATERIAL

import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggle, MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';


import { authInterceptorProviders } from './services/auth.interceptor';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { VetDashboardComponent } from './pages/vet/vet-dashboard/vet-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/welcome/welcome.component';

import { SidebarComponent as UserSidebar} from './pages/user/sidebar/sidebar.component';
import { SidebarComponent as VetSidebar } from './pages/vet/sidebar/sidebar.component';
import { ViewEspecialidadesComponent } from './pages/admin/especialidad/view-especialidades/view-especialidades.component';
import { ViewVeterinariosComponent } from './pages/admin/veterinario/view-veterinarios/view-veterinarios.component';
import { ViewHorariosComponent } from './pages/admin/horario/view-horarios/view-horarios.component';
import { AddHorariosComponent } from './pages/admin/horario/add-horarios/add-horarios.component';
import { AddVeterinariosComponent } from './pages/admin/veterinario/add-veterinarios/add-veterinarios.component';
import { AddEspecialidadesComponent } from './pages/admin/especialidad/add-especialidades/add-especialidades.component';
import { EditVeterinarioComponent } from './pages/admin/veterinario/edit-veterinario/edit-veterinario.component';
import { EditHorarioComponent } from './pages/admin/horario/edit-horario/edit-horario.component';
import { EditEspecialidadComponent } from './pages/admin/especialidad/edit-especialidad/edit-especialidad.component';
import { AddMascotasComponent } from './pages/admin/mascota/add-mascotas/add-mascotas.component';
import { EditMascotaComponent } from './pages/admin/mascota/edit-mascota/edit-mascota.component';
import { ViewMascotasComponent } from './pages/admin/mascota/view-mascotas/view-mascotas.component';
import { ViewUsuariosComponent } from './pages/admin/usuario/view-usuarios/view-usuarios.component';
import { AddUsuariosComponent } from './pages/admin/usuario/add-usuarios/add-usuarios.component';
import { EditUsuarioComponent } from './pages/admin/usuario/edit-usuario/edit-usuario.component';
import { AddRecetaComponent } from './pages/admin/receta/add-receta/add-receta.component';
import { AddReservacitaComponent } from './pages/admin/reserva/add-reservacita/add-reservacita.component';
import { ViewRecetasComponent } from './pages/admin/receta/view-recetas/view-recetas.component';
import { ViewReservacitasComponent } from './pages/admin/reserva/view-reservacitas/view-reservacitas.component';
import { ViewMascotasUsuarioComponent } from './pages/admin/mascota/view-mascotas-usuario/view-mascotas-usuario.component';
import { ViewReservacitasMascotaComponent } from './pages/admin/reserva/view-reservacitas-mascota/view-reservacitas-mascota.component';
import { ViewMascotaloginComponent } from './pages/user/view-mascotalogin/view-mascotalogin.component';
import { ViewReservaloginComponent } from './pages/user/view-reservalogin/view-reservalogin.component';
import { EditReservacitaComponent } from './pages/admin/reserva/edit-reservacita/edit-reservacita.component';
import { EditRecetaComponent } from './pages/admin/receta/edit-receta/edit-receta.component';

//Para fecha en editar reserva
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    UserDashboardComponent,
    VetDashboardComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    UserSidebar,
    VetSidebar,
    ViewEspecialidadesComponent,
    ViewVeterinariosComponent,
    ViewHorariosComponent,
    AddHorariosComponent,
    AddVeterinariosComponent,
    AddEspecialidadesComponent,
    EditVeterinarioComponent,
    EditHorarioComponent,
    EditEspecialidadComponent,
    AddMascotasComponent,
    EditMascotaComponent,
    ViewMascotasComponent,
    ViewUsuariosComponent,
    AddUsuariosComponent,
    EditUsuarioComponent,
    AddRecetaComponent,
    AddReservacitaComponent,
    ViewRecetasComponent,
    ViewReservacitasComponent,
    ViewMascotasUsuarioComponent,
    ViewReservacitasMascotaComponent,
    ViewMascotaloginComponent,
    ViewReservaloginComponent,
    EditRecetaComponent,
    EditReservacitaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
    
  ],
  providers: [authInterceptorProviders, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
