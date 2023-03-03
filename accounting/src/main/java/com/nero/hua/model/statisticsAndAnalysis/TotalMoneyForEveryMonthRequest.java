package com.nero.hua.model.statisticsAndAnalysis;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TotalMoneyForEveryMonthRequest {

    private Date billCreateTimeMin;

    private Date billCreateTimeMax;

    private Double billMoneyMin;

    private Double billMoneyMax;

    private Boolean valuable;

}
