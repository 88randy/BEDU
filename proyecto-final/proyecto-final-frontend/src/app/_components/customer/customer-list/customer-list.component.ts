import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/_services/customer/customer.service';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: any;
  responseStatus = 200;
  searchText: any;
  roles: string[] = [];

  constructor(private customerService: CustomerService, private storageService: StorageService) { }

  ngOnInit() {
    this.roles = this.storageService.getUser().roles;
    this.customerService.getCustomersList().subscribe(
      data => {
        this.customers = data;
      },
      error => {
        console.log(error);
        this.responseStatus = error.status;
      });
  }
}
