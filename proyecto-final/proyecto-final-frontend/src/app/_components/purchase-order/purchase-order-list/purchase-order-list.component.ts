import { Component, OnInit } from '@angular/core';
import { PurchaseOrder } from 'src/app/_interface/purchaseOrder.interface';
import { PurchaseOrderService } from 'src/app/_services/purchase-order/purchase-order.service';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-purchase-order-list',
  templateUrl: './purchase-order-list.component.html',
  styleUrls: ['./purchase-order-list.component.css']
})
export class PurchaseOrderListComponent implements OnInit{
  
  purchaseOrders!: PurchaseOrder[];
  responseStatus = 200;
  searchText: any;
  roles: string[] = [];

  constructor(private purchaseOrderService: PurchaseOrderService, private storageService: StorageService) { }

  ngOnInit() {
    this.roles = this.storageService.getUser().roles;
    this.purchaseOrderService.getPurchaseOrderList().subscribe(data => {
      this.purchaseOrders = data;
    },error => {
      console.log(error);
      this.responseStatus = error.status;
    });
  }

  getTotal(purchaseOrder: PurchaseOrder): number {
    let total = 0;
    for (let item of purchaseOrder.items) {
      total += item.quantity * item.product.price;
    }
    return total;
  }
}
