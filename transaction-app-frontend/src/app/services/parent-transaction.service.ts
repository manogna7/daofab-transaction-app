import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ParentTransaction } from '../models/parent-transaction';

@Injectable({
  providedIn: 'root',
})
export class ParentTransactionService {
  private apiUrl = 'http://localhost:8080/api/parent-transactions';

  constructor(private http: HttpClient) {}

  getParentTransactions(): Observable<ParentTransaction[]> {
    return this.http.get<ParentTransaction[]>(
      `${this.apiUrl}/parent-transactions`
    );
  }
}
