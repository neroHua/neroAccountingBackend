package com.nero.hua.service;

import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthResponse;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEverydayRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEverydayResponse;

import java.util.List;

public interface StatisticsAndAnalysisService {

    List<TotalMoneyForEveryMonthResponse> getTotalMoneyForEveryMonth(TotalMoneyForEveryMonthRequest totalMoneyForEveryMonthRequest, String userId);

    List<TotalMoneyForEverydayResponse> getTotalMoneyForEveryday(TotalMoneyForEverydayRequest totalMoneyForEverydayRequest, String userId);
}
