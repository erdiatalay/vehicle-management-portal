import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateVehicleComponent } from './components/create-vehicle/create-vehicle.component';
import { ListVehicleComponent } from './components/list-vehicle/list-vehicle.component';
import { ViewVehicleComponent } from './components/view-vehicle/view-vehicle.component';
import { UpdateVehicleComponent } from './components/update-vehicle/update-vehicle.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateVehicleComponent,
    ListVehicleComponent,
    ViewVehicleComponent,
    UpdateVehicleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
