import { Component, OnInit } from '@angular/core';
import { ParentTransaction } from '../models/parent-transaction.model';
import { ParentTransactionService } from '../services/parent-transaction.service';

@Component({
  selector: 'app-parent-transaction',
  templateUrl: './parent-transaction.component.html',
  styleUrls: ['./parent-transaction.component.css']
})
export class ParentTransactionComponent implements OnInit {
  parentTransactions: ParentTransaction[] = [];

  constructor(private parentTransactionService: ParentTransactionService) {}

  ngOnInit() {
    this.fetchParentTransactions();
  }

  fetchParentTransactions() {
    this.parentTransactionService.getParentTransactions().subscribe(
      transactions => {
        this.parentTransactions = transactions;
      },
      error => {
        console.error('Error fetching parent transactions:', error);
      }
    );
  }

  calculateTotalPaidAmount(parentId: number): number {
    // Implement logic to calculate the total paid amount for a given parent ID
    // by fetching child data or processing it from the available data
    return 0; // Replace with the actual calculation
  }
}
