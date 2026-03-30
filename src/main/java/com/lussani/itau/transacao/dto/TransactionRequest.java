package com.lussani.itau.transacao.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransactionRequest(
    @Positive double valor,
    @NotNull OffsetDateTime dataHora
){}