import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { BookingService } from '../Service/booking.service';
import { Router } from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit{
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
    this.router.navigateByUrl("/dashboard");    
  }

}
