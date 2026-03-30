package com.lussani.itau.transacao.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lussani.itau.transacao.dto.StatisticsResponse;
import com.lussani.itau.transacao.dto.TransactionRequest;

@Service
public class TransactionService {
    private final Queue<TransactionRequest> transactions = new ConcurrentLinkedQueue<>();

    private void validateTransaction(TransactionRequest transaction){
        if(transaction.valor() <= 0 || transaction.dataHora().isAfter(OffsetDateTime.now())){
            throw new ResponseStatusException(HttpStatusCode.valueOf(422));
        }
    }

    public void addTransaction(TransactionRequest transaction){
        validateTransaction(transaction);
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    public StatisticsResponse getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();

        DoubleSummaryStatistics stats = transactions.stream()
            .filter(t -> t.dataHora().isAfter(now.minusSeconds(60)))
            .mapToDouble(TransactionRequest::valor)
            .summaryStatistics();

        return new StatisticsResponse(stats);
    }
}