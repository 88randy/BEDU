import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaProductosComponent } from './productos/lista-productos/lista-productos.component';
import { InfoUsuarioComponent } from './usuarios/info-usuario/info-usuario.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: "", redirectTo: "/productos", pathMatch: "full" },
  { path: "productos", component: ListaProductosComponent },
  { path: "usuarios/:id", component: InfoUsuarioComponent, canActivate: [AuthGuard]},
  { path: "**", component: NotFoundComponent }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
