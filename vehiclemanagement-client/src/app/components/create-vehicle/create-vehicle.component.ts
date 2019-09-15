import { Component, OnInit } from '@angular/core';
import { Vehicle } from 'src/app/models/vehicle';
import { VehicleService } from 'src/app/services/vehicle/vehicle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-vehicle',
  templateUrl: './create-vehicle.component.html',
  styleUrls: ['./create-vehicle.component.css']
})
export class CreateVehicleComponent implements OnInit {


  vehicle: Vehicle = new Vehicle();
  submitted = false;

  constructor(private vehicleService: VehicleService, private router: Router) { }
  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  save() {
    this.vehicleService.createVehicle(this.vehicle)
      .subscribe(data => console.log(data), error => console.log(error));
    this.vehicle = new Vehicle();
    this.list();
  }

  list() {
    this.router.navigate(['/vehicles']);
  }

}
