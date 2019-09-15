import { ListVehicleComponent } from './components/list-vehicle/list-vehicle.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: '', redirectTo: 'vehicles', pathMatch: 'full' },
  { path: 'vehicles', component: ListVehicleComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
