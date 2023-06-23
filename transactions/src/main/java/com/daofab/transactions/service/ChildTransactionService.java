package com.daofab.transactions.service;

import com.daofab.transactions.ChildTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildTransactionService {

    private final List<ChildTransaction> childTransactions;

    public ChildTransactionService() throws IOException {
        this.childTransactions = getAllChildTransactions();
    }

    public List<ChildTransaction> getChildTransactions(int parentId) {
        return childTransactions.stream()
                .filter(childTransaction -> childTransaction.getParentId() == parentId)
                .collect(Collectors.toList());
    }

    private List<ChildTransaction> getAllChildTransactions() throws IOException {
        Gson gson = new Gson();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Child.json");
        InputStreamReader reader = new InputStreamReader(inputStream);

        Type listType = new TypeToken<List<ChildTransaction>>() {}.getType();
        return gson.fromJson(reader, listType);
    }
}
