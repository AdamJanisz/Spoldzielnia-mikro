import { AddStudentComponent } from './add-student/add-student.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { BillsComponent } from './list-bill/bills.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {AddBillComponent} from "./add-bill/add-bill.component";
import {BuildingsComponent} from "./building-list/buildings.component";
import {AddApartmentComponent} from "./add-appartment/add-apartment.component";
import {AddBuildingComponent} from "./add-building/add-building.component";
import {LoginComponent} from './login/login.component';


// Delkaracja na jakim url ma się wyrenderować jaki komponent. Pojawi się w miejscu deklaracji <router-outlet>
const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'enrolment', component: AddStudentComponent },
  { path: 'editBill/:id',component: AddBillComponent},
  { path: 'allBills/:id',component: BillsComponent},
  { path: 'allBuildings',component: BuildingsComponent},
  { path: 'addAppartment',component: AddApartmentComponent},
  { path: 'addBuilding',component: AddBuildingComponent},
  { path: 'login', component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
