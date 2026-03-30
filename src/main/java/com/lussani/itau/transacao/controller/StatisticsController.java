package com.lussani.itau.transacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lussani.itau.transacao.dto.StatisticsResponse;
import com.lussani.itau.transacao.service.TransactionService;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> get(){
        return ResponseEntity.ok(transactionService.getStatistics());
    }
}