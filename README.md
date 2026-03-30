# Desafio Backend - Estatísticas de Transações

Projeto desenvolvido como solução para um desafio técnico inspirado no desafio do Itaú.

A aplicação expõe uma API REST para registro de transações e cálculo de estatísticas com base nas transações dos últimos 60 segundos.

---

## Tecnologias

- Java
- Spring Boot
- Maven

---

## Funcionalidades

- Criar transações  
- Remover todas as transações  
- Calcular estatísticas (últimos 60 segundos)

---

## Endpoints

### POST /transacao
Cria uma nova transação

**Body:**
```json
{
  "valor": 100.0,
  "dataHora": "2026-03-29T12:34:56.789-03:00"
}
```

---

### DELETE /transacao
Remove todas as transações

---

### GET /estatistica
Retorna estatísticas das transações dos últimos 60 segundos

**Response:**
```json
{
  "count": 10,
  "sum": 1000.0,
  "avg": 100.0,
  "min": 50.0,
  "max": 200.0
}
```

---

## Regras

- Valor deve ser maior que zero  
- Não aceita transações com data no futuro  
- Estatísticas consideram apenas os últimos 60 segundos  

---

## Referência

Desafio original:  
https://github.com/feltex/desafio-itau-backend.git
