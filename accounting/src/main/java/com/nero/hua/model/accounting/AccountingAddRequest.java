package com.nero.hua.model.accounting;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class AccountingAddRequest {
    @NotNull(message = "账单创建时间不能为空")
    private Date billCreateTime;

    @NotNull(message = "账单金额不能为空")
    @Min(value = 0, message = "账单金额不能小于0")
    private Double billMoney;

    @Length(max = 64, message = "描述字长不能超过64")
    private String description;

    @Length(max = 64, message = "复盘描述字长不能超过64")
    private String reviewDescription;

    private Boolean valuable;

    private List<Long> tagIdList;

}
