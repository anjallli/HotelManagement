import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../Service/customer.service';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent {
  user2!: Customer;
  constructor(public activateroute:ActivatedRoute,private route:Router,private customerService:CustomerService) { }
 
  id!: number;
  ngOnInit(): void 
  {
    this.activateroute.paramMap.subscribe(()=>this.user2=JSON.parse(sessionStorage.getItem("user2")||'{}'))
    
  }

  BookRoom(id:number){
    this.route.navigateByUrl("/roombooking/"+id);

  }
  ViewRoom(){
    

  }
//findcustomerbyUsername write here logic
  
logout() {
    if (sessionStorage.getItem("user2")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.route.navigateByUrl("")
    }
    else {
      alert("No user loged in")
    }
  }
}
