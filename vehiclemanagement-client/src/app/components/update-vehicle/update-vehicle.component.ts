import { VehicleService } from './../../services/vehicle/vehicle.service';
import { Component, OnInit } from '@angular/core';
import { Vehicle } from 'src/app/models/vehicle';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-vehicle',
  templateUrl: './update-vehicle.component.html',
  styleUrls: ['./update-vehicle.component.css']
})
export class UpdateVehicleComponent implements OnInit {

  id: number;
  vehicle: Vehicle;
  submitted = false;

  constructor(private vehicleService: VehicleService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.vehicle = new Vehicle();

    this.id = this.route.snapshot.params.id;

    this.vehicleService.getVehicle(this.id)
      .subscribe(
        data => {
          console.log(data);
          this.vehicle = data;
        }, error => console.log(error)
      );
  }

  onSubmit() {
    this.vehicleService.updateVehicle(this.id, this.vehicle)
      .subscribe(
        data => {
          console.log(data);
          this.vehicle = data;
        }, error => console.log(error)
      );
    this.listVehicles();
  }

  listVehicles() {
    this.router.navigate(['/vehicles']);
  }

}
