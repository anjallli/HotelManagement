import { Component } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../Service/customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent {
  user2: Customer = new Customer(0, "", "", "", "","","")

  users: Customer = JSON.parse(sessionStorage.getItem("user2") || '{}')

  constructor(private userservices: CustomerService, private route: Router, public activateRoute: ActivatedRoute) { }
 
 
  ngOnInit(): void {
  }
  Getlogin(): void {

    this.userservices.getlogin(this.user2).subscribe(data => {
      alert("Login Successfully"),
        console.log("login response" + data)

      sessionStorage.setItem("user2", JSON.stringify(data))

      this.route.navigateByUrl("/customerdashboard")

    },
      error => alert("Sorry Please Enter correct Username And Password"));

  }

  newregistration(){
    this.route.navigateByUrl("/addcustomer"); 
  }

  goToDashboard(){
    this.route.navigateByUrl(""); 

  }

}
