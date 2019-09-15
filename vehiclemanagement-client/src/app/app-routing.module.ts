import { ListVehicleComponent } from './components/list-vehicle/list-vehicle.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateVehicleComponent } from './components/create-vehicle/create-vehicle.component';


const routes: Routes = [
  { path: '', redirectTo: 'vehicles', pathMatch: 'full' },
  { path: 'vehicles', component: ListVehicleComponent },
  { path: 'add', component:  CreateVehicleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
