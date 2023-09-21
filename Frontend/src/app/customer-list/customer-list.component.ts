import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../Service/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit{

  customers!: Customer[]; 

  constructor(public router:Router,private customerService:CustomerService){}

  ngOnInit(): void {
 
    this.getCustomer();
   
  }

  getCustomer(){
    this.customerService.getCustomer().subscribe(data=>{
      console.log(data);
      this.customers=data;
    });
  }

  addCustomer():void{
    this.router.navigateByUrl("addCustomer");
    
  }

  updateCustomer(id:number){
    this.router.navigateByUrl("/updateCustomer/"+id);

  }
  BookRoom(id:number){
    this.router.navigateByUrl("/bookRoom/"+id);

  }

  deleteCustomer(id:number):void
  {
    console.log(id);
    if(confirm("Do you want to delete ?")){
      this.customerService. deleteCustomer(id).subscribe(data=>{
        console.log(data);
        this.getCustomer();
      })
    };
  }

  goToDashboard(){
    this.router.navigateByUrl("/dashboard");    
  }
}
