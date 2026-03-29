package com.lussani.itau.transacao.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record TransactionRequest(
    @NotNull @DecimalMin("0.0") BigDecimal valor,
    @NotNull OffsetDateTime dataHora
){}