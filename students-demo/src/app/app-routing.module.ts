import { AddStudentComponent } from './add-student/add-student.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {AddBillComponent} from "./add-bill/add-bill.component";
import {BillsComponent} from "./list-bill/bills.component";
import {BuildingsComponent} from "./building-list/buildings.component";
import {AddAppartmentComponent} from "./add-appartment/add-appartment.component";

// Delkaracja na jakim url ma się wyrenderować jaki komponent. Pojawi się w miejscu deklaracji <router-outlet>
const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'enrolment', component: AddStudentComponent },
  { path: 'enrolment', component: AddStudentComponent },
  { path: 'editBill/:id',component: AddBillComponent},
  { path: 'allBills',component: BillsComponent},
  { path: 'allBuildings',component: BuildingsComponent},
  { path: 'addAppartment',component: AddAppartmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
