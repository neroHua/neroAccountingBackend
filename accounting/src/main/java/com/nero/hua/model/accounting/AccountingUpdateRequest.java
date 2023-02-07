package com.nero.hua.model.accounting;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class AccountingUpdateRequest {

    @NotNull(message = "id不能为空")
    @Min(value = 0, message = "id不能小于0")
    private Long id;

    private Date billCreateTime;

    @Min(value = 0, message = "账单金额不能小于0")
    private Double billMoney;

    @Length(max = 64, message = "描述字长不能超过64")
    private String description;

    @Length(max = 64, message = "复盘描述字长不能超过64")
    private String reviewDescription;

    private Boolean valuable;

}
