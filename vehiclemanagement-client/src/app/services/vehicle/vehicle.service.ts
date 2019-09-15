import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.constants';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  retrieveAllVehicles(): Observable<any> {
    return this.http.get(`${API_URL}/vehicles/`);
  }

  createVehicle(vehicle: Object): Observable<Object>{
    return this.http.post(`${API_URL}/vehicle/`, vehicle);
  }
}
