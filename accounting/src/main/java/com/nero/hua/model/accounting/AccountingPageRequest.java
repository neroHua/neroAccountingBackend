package com.nero.hua.model.accounting;

import com.nero.hua.model.base.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AccountingPageRequest extends BasePageRequest {

    private Date billCreateTimeMin;

    private Date billCreateTimeMax;

    private Double billMoneyMin;

    private Double billMoneyMax;

    private Boolean valuable;

}
