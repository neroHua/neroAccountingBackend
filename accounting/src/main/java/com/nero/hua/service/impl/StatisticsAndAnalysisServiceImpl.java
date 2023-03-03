package com.nero.hua.service.impl;

import com.nero.hua.dao.AccountingDAO;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthResponse;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEverydayRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEverydayResponse;
import com.nero.hua.service.StatisticsAndAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsAndAnalysisServiceImpl implements StatisticsAndAnalysisService {

    @Autowired
    AccountingDAO accountingDAO;

    @Override
    public List<TotalMoneyForEveryMonthResponse> getTotalMoneyForEveryMonth(TotalMoneyForEveryMonthRequest totalMoneyForEveryMonthRequest, String userId) {
        return accountingDAO.getTotalMoneyForEveryMonth(totalMoneyForEveryMonthRequest);
    }

    @Override
    public List<TotalMoneyForEverydayResponse> getTotalMoneyForEveryday(TotalMoneyForEverydayRequest totalMoneyForEverydayRequest, String userId) {
        return accountingDAO.getTotalMoneyForEveryday(totalMoneyForEverydayRequest);
    }

}
