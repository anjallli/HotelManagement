import { Component } from '@angular/core';
import { CustomerService } from '../Service/customer.service';
import { Customer } from '../customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerside-addcustomer',
  templateUrl: './customerside-addcustomer.component.html',
  styleUrls: ['./customerside-addcustomer.component.css']
})
export class CustomersideAddcustomerComponent {


  customer:Customer = new Customer(0,"","","","","","");
  isEditable: any;



  constructor(private customerService:CustomerService, private router:Router){}
  ngOnInit(): void {
    
  }
  

  onSubmit(){
    console.log(this.customer);
    alert("Registration successfully done!");
    this.customerService.SaveEmployee( this.customer ).subscribe(data =>
      
      console.log(data));
      this.router.navigateByUrl("customerlogin");
    }
    goToDashboard(){
      this.router.navigateByUrl("/customerlogin");    
    }
    onlyNumbers(event: {keyCode: any; which: any;}):boolean{
      const charCode = (event.which)?event.which:event.keyCode;
      if(charCode>31 && (charCode<48 || charCode>57))
      {
        console.log("chacode restricted : "+charCode);
        return false;
      }
      return true;

    }
}
