package com.nero.hua.service;

import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthResponse;

import java.util.List;

public interface StatisticsAndAnalysisService {

    List<TotalMoneyForEveryMonthResponse> getTotalMoneyForEveryMonth(TotalMoneyForEveryMonthRequest totalMoneyForEveryMonthRequest, String userId);

}
