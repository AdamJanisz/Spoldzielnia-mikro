import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../services/students.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss']
})
export class StudentsComponent implements OnInit {

  // Ustawianie nazw kolumn w tabeli
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email', 'telephone', 'username', 'password', 'action'];
  dataSource;

  constructor(private studentService: StudentsService) { }

  // Podczas inicjalizacji komponentu wywoływana jest metoda z students.service odpytująca GatewayService
  // Następnie lista studentów otrzymana z GatewayService jest ładowana do tabeli MatTableDataSource
  // Korzystając z komponentów Angular Material dostajemy za darmo często używane funkcjonalności takie jak filtrowanie, sortowanie itp.
  // https://material.angular.io/components/table/overview
  ngOnInit() {
    this.studentService.getStudents().subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
    });
  }

  // Filtrowanie rekordów w tabeli
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
