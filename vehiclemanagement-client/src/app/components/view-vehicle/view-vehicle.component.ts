import { VehicleService } from 'src/app/services/vehicle/vehicle.service';
import { Vehicle } from './../../models/vehicle';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-vehicle',
  templateUrl: './view-vehicle.component.html',
  styleUrls: ['./view-vehicle.component.css']
})
export class ViewVehicleComponent implements OnInit {

  id: number;
  vehicle: Vehicle;

  constructor(private vehicleService: VehicleService, private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.vehicle = new Vehicle();
    this.id = this.route.snapshot.params['id'];

    this.vehicleService.getVehicle(this.id).subscribe(
      data => {
        console.log(data);
        this.vehicle = data;
      }, error => console.log(error)
    );
  }

  list() {
    this.router.navigate(['/vehicles']);
  }

}
