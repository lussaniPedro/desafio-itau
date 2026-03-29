package com.lussani.itau.transacao.dto;

import java.util.DoubleSummaryStatistics;

public record StatisticsResponse(long count, double min, double max, double sum, double avg){
    public StatisticsResponse(DoubleSummaryStatistics stats){
        this(
            stats.getCount(),
            stats.getCount() > 0 ? stats.getMin() : 0,
            stats.getCount() > 0 ? stats.getMax() : 0,
            stats.getSum(),
            stats.getAverage()
        );
    }
}