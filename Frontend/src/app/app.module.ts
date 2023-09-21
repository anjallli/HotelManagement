import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { FormsModule} from '@angular/forms';
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

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    AddBookingComponent,
    BookingListComponent,
    DashboardComponent,
    RoomtypeComponent,
    OwnerLoginComponent,
    
    LogindashboardComponent,
    CustomerLoginComponent,
    CustomerdashboardComponent,
    CustomersidebookingComponent,
    CustomerallbookingsComponent,
    CustomersideAddcustomerComponent,
    CustomersideroomtypesComponent,
    CustomersideroombookformComponent,
    PaymentModuleComponent,
    CustomerSidePaymentComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
