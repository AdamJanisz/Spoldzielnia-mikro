import {Component, OnInit} from '@angular/core';
import {BillService} from '../services/bill.service';
import {MatTableDataSource} from '@angular/material/table';
import {StudentsService} from "../services/students.service";
import {ApartmentService} from "../services/apartment.service";
import {Apartment} from "../models/apartment";


@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.scss']
})
export class BillsComponent implements OnInit {

  // Ustawianie nazw kolumn w tabeli

  displayedColumns: string[] = ['id', 'date', 'electricity', 'hotWater', 'coldWater', 'sewage', 'maintenanceFund', 'totalAmount', 'action'];
  dataSource;

  constructor(private billService: BillService, private apartmentService: ApartmentService) {
  }
  // Podczas inicjalizacji komponentu wywoływana jest metoda z students.service odpytująca GatewayService
  // Następnie lista studentów otrzymana z GatewayService jest ładowana do tabeli MatTableDataSource
  // Korzystając z komponentów Angular Material dostajemy za darmo często używane funkcjonalności takie jak filtrowanie, sortowanie itp.
  // https://material.angular.io/components/table/overview
  ngOnInit() {
    console.log('trwa sprawdzanie apartamentu')
    this.apartmentService.getLoggedApartment(window.sessionStorage.getItem('username')).subscribe(apartments =>
      apartments.forEach(apartment => {
        this.billService.getBills(apartment.id).subscribe(response => {
          this.dataSource = new MatTableDataSource(response);
        });
  }));
  }

  // Filtrowanie rekordów w tabeli
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
