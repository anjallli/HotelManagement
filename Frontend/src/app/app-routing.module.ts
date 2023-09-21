import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RoomtypeComponent } from './roomtype/roomtype.component';
import { OwnerLoginComponent } from './owner-login/owner-login.component';

import { LogindashboardComponent } from './usermodule/logindashboard/logindashboard.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { CustomersidebookingComponent } from './customersidebooking/customersidebooking.component';
import { CustomerallbookingsComponent } from './customerallbookings/customerallbookings.component';
import { CustomersideAddcustomerComponent } from './customerside-addcustomer/customerside-addcustomer.component';
import { CustomersideroomtypesComponent } from './customersideroomtypes/customersideroomtypes.component';
import { CustomersideroombookformComponent } from './customersideroombookform/customersideroombookform.component';
import { PaymentModuleComponent } from './payment-module/payment-module.component';
import { CustomerSidePaymentComponent } from './customer-side-payment/customer-side-payment.component';


const routes: Routes = [
  {path:'dashboard/customers',component:CustomerListComponent},
  {path:'dashboard/addCustomer',component:AddCustomerComponent},
  {path:'updateCustomer/:id',component:UpdateCustomerComponent},
  {path:'bookRoom/:id',component:AddBookingComponent},
  {path:'dashboard/bookings',component:BookingListComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'dashboard/roomtype',component:RoomtypeComponent},
  {path:'ownerlogin',component: OwnerLoginComponent},

  
  
  {path:'',component: LogindashboardComponent},

  {path:'customerlogin',component: CustomerLoginComponent},
  {path:'customerdashboard',component:CustomerdashboardComponent},
  
  {path:'roombooking/:id',component: CustomersidebookingComponent},
  {path:'customerdashboard/customerallbookings',component: CustomerallbookingsComponent},
  {path:'addcustomer',component: CustomersideAddcustomerComponent},
  {path:'customerdashboard/roomtypesbooking',component: CustomersideroomtypesComponent},
  {path:'roombookingform/:id',component: CustomersideroombookformComponent},
  {path:'payment/:id/:total',component: PaymentModuleComponent},
  
  {path:'customerSidepayment/:id/:total',component: CustomerSidePaymentComponent}
  
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
