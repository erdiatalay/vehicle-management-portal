import { VehicleService } from './../../services/vehicle/vehicle.service';
import { Component, OnInit } from '@angular/core';
import { Vehicle } from 'src/app/models/vehicle';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-vehicle',
  templateUrl: './list-vehicle.component.html',
  styleUrls: ['./list-vehicle.component.css']
})
export class ListVehicleComponent implements OnInit {
  vehicles: Observable<Vehicle[]>;

  constructor(private vehicleService: VehicleService, private router: Router) { }

  ngOnInit() {
    this.reloadVehicleList();
  }

  reloadVehicleList() {
    this.vehicles = this.vehicleService.retrieveAllVehicles();
  }

  deleteVehicle(id: number) {
    this.vehicleService.deleteVehicle(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadVehicleList();
        },
        error => console.log(error));
  }

  vehicleDetails(id: number) {
    this.router.navigate(['/details', id]);
  }
}
