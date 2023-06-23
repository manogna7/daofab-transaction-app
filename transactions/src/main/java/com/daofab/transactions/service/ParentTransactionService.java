package com.daofab.transactions.service;

import com.daofab.transactions.ParentTransaction;
import com.daofab.transactions.ChildTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParentTransactionService {

    private final ChildTransactionService childTransactionService;

    public ParentTransactionService(ChildTransactionService childTransactionService) {
        this.childTransactionService = childTransactionService;
    }

    public List<ParentTransaction> getParentTransactions(int page, int pageSize, String sortBy) throws IOException {
        List<ParentTransaction> parentTransactions = getAllParentTransactions();
        // Apply pagination
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, parentTransactions.size());
        parentTransactions = parentTransactions.subList(startIndex, endIndex);
        // Apply sorting based on the sortBy parameter
        sortParentTransactions(parentTransactions, sortBy);
        // Calculate total paid amount for each parent transaction
        calculateTotalPaidAmount(parentTransactions);
        return parentTransactions;
    }

    private List<ParentTransaction> getAllParentTransactions() throws IOException {
        Gson gson = new Gson();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Parent.json");
        InputStreamReader reader = new InputStreamReader(inputStream);

        Type listType = new TypeToken<List<ParentTransaction>>() {}.getType();
        return gson.fromJson(reader, listType);
    }

    private void calculateTotalPaidAmount(List<ParentTransaction> parentTransactions) {
        if (!CollectionUtils.isEmpty(parentTransactions)) {
            Map<Integer, Double> parentPaidAmounts = new HashMap<>();
            for (ParentTransaction parentTransaction : parentTransactions) {
                List<ChildTransaction> childTransactions = childTransactionService.getChildTransactions(parentTransaction.getId());
                double totalPaidAmount = childTransactions.stream()
                        .mapToDouble(ChildTransaction::getPaidAmount)
                        .sum();
                parentTransaction.setTotalPaidAmount(totalPaidAmount);
            }
        }
    }

    private void sortParentTransactions(List<ParentTransaction> parentTransactions, String sortBy) {
        // Implement sorting logic based on the sortBy parameter
        // For simplicity, let's assume we sort based on the parent id
        parentTransactions.sort((t1, t2) -> t1.getId() - t2.getId());
    }
}
