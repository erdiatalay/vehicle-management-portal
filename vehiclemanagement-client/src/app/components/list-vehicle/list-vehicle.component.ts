import { VehicleService } from './../../services/vehicle/vehicle.service';
import { Component, OnInit } from '@angular/core';
import { Vehicle } from 'src/app/models/vehicle';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-vehicle',
  templateUrl: './list-vehicle.component.html',
  styleUrls: ['./list-vehicle.component.css']
})
export class ListVehicleComponent implements OnInit {
  vehicles: Observable<Vehicle[]>;

  constructor(private vehicleService: VehicleService) { }

  ngOnInit() {
    this.reloadVehicleList();
  }

  reloadVehicleList() {
    this.vehicles = this.vehicleService.retrieveAllVehicles();
  }

}
