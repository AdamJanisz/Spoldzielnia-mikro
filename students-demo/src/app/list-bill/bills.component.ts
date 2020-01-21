import {Component, OnInit} from '@angular/core';
import {BillService} from '../services/bill.service';
import {MatTableDataSource} from '@angular/material/table';
import {ApartmentService} from "../services/apartment.service";
import {ActivatedRoute} from "@angular/router";
import {ToastrService} from "ngx-toastr";



@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.scss']
})
export class BillsComponent implements OnInit {

  // Ustawianie nazw kolumn w tabeli
  displayedColumns: string[] = ['id', 'date', 'electricity', 'hotWater', 'coldWater', 'sewage', 'maintenanceFund', 'totalAmount', 'action', 'accept'];
  dataSource;

  constructor(private route: ActivatedRoute, private toastr: ToastrService, private billService: BillService, private apartmentService: ApartmentService) {
  }




  // Podczas inicjalizacji komponentu wywoływana jest metoda z students.service odpytująca GatewayService
  // Następnie lista studentów otrzymana z GatewayService jest ładowana do tabeli MatTableDataSource
  // Korzystając z komponentów Angular Material dostajemy za darmo często używane funkcjonalności takie jak filtrowanie, sortowanie itp.
  // https://material.angular.io/components/table/overview
  ngOnInit() {
    this.route.paramMap.subscribe(parameterMap => {
      const id = +parameterMap.get('id');
      if ( id > 0) { this.billService.confirmBill(id).subscribe(data => {
          this.toastr.success('Sukces!', 'Rachunek został potwierdzony');
        },
        error => {
          this.toastr.error('Błąd!', 'Rachunek nie został potwierdzony');
        }); }
    });
    if (window.sessionStorage.getItem('currentRole') === 'ROLE_USER') {
      console.log('userbils');
      this.apartmentService.getLoggedApartment(window.sessionStorage.getItem('username')).subscribe(apartments =>
        apartments.forEach(apartment => {
          this.billService.getBills(apartment.id).subscribe(response => {
            this.dataSource = new MatTableDataSource(response);
          });
        }));
    } else {
      console.log('allBils');
      this.billService.getAllBills().subscribe(response => {
        this.dataSource = new MatTableDataSource(response);
      });
    }

  }

  // Filtrowanie rekordów w tabeli
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
