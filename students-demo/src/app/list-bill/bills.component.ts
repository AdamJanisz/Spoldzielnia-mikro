import { Component, OnInit } from '@angular/core';
import { BillService } from '../services/bill.service';
import { MatTableDataSource } from '@angular/material/table';
import {StudentsService} from "../services/students.service";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.scss']
})
export class BillsComponent implements OnInit {

  // Ustawianie nazw kolumn w tabeli
  displayedColumns: string[] = ['id', 'date', 'electricity', 'hotWater', 'coldWater', 'sewage', 'repairFund', 'action'];
  dataSource;

  constructor(private billService: BillService) { }

  // Podczas inicjalizacji komponentu wywoływana jest metoda z students.service odpytująca GatewayService
  // Następnie lista studentów otrzymana z GatewayService jest ładowana do tabeli MatTableDataSource
  // Korzystając z komponentów Angular Material dostajemy za darmo często używane funkcjonalności takie jak filtrowanie, sortowanie itp.
  // https://material.angular.io/components/table/overview
  ngOnInit() {
    this.billService.getBills().subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
    });
  }

  // Filtrowanie rekordów w tabeli
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
