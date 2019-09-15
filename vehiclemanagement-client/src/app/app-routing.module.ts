import { UpdateVehicleComponent } from './components/update-vehicle/update-vehicle.component';
import { ViewVehicleComponent } from './components/view-vehicle/view-vehicle.component';
import { ListVehicleComponent } from './components/list-vehicle/list-vehicle.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateVehicleComponent } from './components/create-vehicle/create-vehicle.component';


const routes: Routes = [
  { path: '', redirectTo: 'vehicles', pathMatch: 'full' },
  { path: 'vehicles', component: ListVehicleComponent },
  { path: 'add', component:  CreateVehicleComponent},
  { path: 'details/:id', component:  ViewVehicleComponent},
  { path: 'update/:id', component:  UpdateVehicleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
