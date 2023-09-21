import { Component } from '@angular/core';
import { Booking } from '../booking';
import { Customer } from '../customer';
import { Router } from '@angular/router';
import { BookingService } from '../Service/booking.service';

@Component({
  selector: 'app-customerallbookings',
  templateUrl: './customerallbookings.component.html',
  styleUrls: ['./customerallbookings.component.css']
})
export class CustomerallbookingsComponent {

  bookings!: Booking[];
  customers!: Customer[];
  constructor(public router:Router,private bookingService:BookingService){}

  ngOnInit(): void {
 
    this.getBookings();
   
  }


  getBookings(){
    this.bookingService.getBookings().subscribe(data=>{
      console.log(data);
      this.bookings=data;
    });
  }

  
  goToDashboard(){
    this.router.navigateByUrl("/customerdashboard");    
  }
}
