package com.nero.hua.controller;

import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthResponse;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEverydayRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEverydayResponse;
import com.nero.hua.service.StatisticsAndAnalysisService;
import com.nero.hua.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/statisticsAndAnalysis")
public class StatisticsAndAnalysisController {

    @Autowired
    StatisticsAndAnalysisService statisticsAndAnalysisService;

    @GetMapping("/totalMoneyForEveryMonth")
    public BaseResponse<List<TotalMoneyForEveryMonthResponse>> getTotalMoneyForEveryMonth(@Validated TotalMoneyForEveryMonthRequest totalMoneyForEveryMonthRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        List<TotalMoneyForEveryMonthResponse> totalMoneyForEveryMonthResponseList = statisticsAndAnalysisService.getTotalMoneyForEveryMonth(totalMoneyForEveryMonthRequest, userId);

        return new BaseResponse<>(totalMoneyForEveryMonthResponseList);
    }

    @GetMapping("/totalMoneyForEveryday")
    public BaseResponse<List<TotalMoneyForEverydayResponse>> getTotalMoneyForEveryday(@Validated TotalMoneyForEverydayRequest totalMoneyForEverydayRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        List<TotalMoneyForEverydayResponse> totalMoneyForEverydayResponseList = statisticsAndAnalysisService.getTotalMoneyForEveryday(totalMoneyForEverydayRequest, userId);

        return new BaseResponse<>(totalMoneyForEverydayResponseList);
    }
}
