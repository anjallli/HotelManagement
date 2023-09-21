import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { Customer } from '../customer';
import { BookingService } from '../Service/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../Service/customer.service';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {
  id!: number;
  result!: number;

  customer:Customer = new Customer(0,"","","","","","");
  booking :Booking = new Booking(0,0,0,'',0,0);
  constructor(private bookingService:BookingService,private route:ActivatedRoute,private router:Router,private customerService:CustomerService){}
 
  ngOnInit(): void {
    this.id= this.route.snapshot.params['id'];
    this.customerService.getCustomerById(this.id).subscribe(data=>{this.customer=data;},error=>console.log(error));
   }
 
    

    Calculate(v:string,b:string){
      this.result=parseInt(v)*parseInt(b);
   
  
     }
     
  Book(id:number){
      console.log(this.result);
      console.log(this.customer.employeeId);
      this.booking.totalAmount=this.result;
      this.booking.customerId=this.id;
      console.log(this.booking);
      this.bookingService.bookRoom(this.booking).subscribe(data=>{
        
        this.router.navigateByUrl("payment/"+id+"/"+this.result)});

        
  ///dashboard/bookings
      }
     
   /*   Pay(id:number){

      console.log(this.result);
      console.log(this.customer.employeeId);
      this.booking.totalAmount=this.result;
      this.booking.customerId=this.id;
      console.log(this.booking);
      this.bookingService.bookRoom(this.booking).subscribe(data=>
      this.router.navigateByUrl("payment/"+id));
        

      }*/


}
