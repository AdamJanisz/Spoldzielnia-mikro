import { Component, OnInit } from '@angular/core';
import { BillService } from '../services/bill.service';
import { MatTableDataSource } from '@angular/material/table';
import {BuildingService} from "../services/building.service";

@Component({
  selector: 'app-buildings',
  templateUrl: './buildings.component.html',
  styleUrls: ['./buildings.component.scss']
})
export class BuildingsComponent implements OnInit {

  // Ustawianie nazw kolumn w tabeli
  displayedColumns: string[] = ['id','city','street','buildingNumber','electricityPrice', 'hotWaterPrice', 'coldWaterPrice', 'sewagePrice', 'maintenanceFundPrice','owner','action'];
  dataSource;

  constructor(private buildingService: BuildingService) { }

  // Podczas inicjalizacji komponentu wywoływana jest metoda z students.service odpytująca GatewayService
  // Następnie lista studentów otrzymana z GatewayService jest ładowana do tabeli MatTableDataSource
  // Korzystając z komponentów Angular Material dostajemy za darmo często używane funkcjonalności takie jak filtrowanie, sortowanie itp.
  // https://material.angular.io/components/table/overview
  ngOnInit() {
    this.buildingService.getBuildings().subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
    });
  }

  // Filtrowanie rekordów w tabeli
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
