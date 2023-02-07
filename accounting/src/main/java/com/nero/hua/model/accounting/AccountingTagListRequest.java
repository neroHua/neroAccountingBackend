package com.nero.hua.model.accounting;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountingTagListRequest {

    @NotNull(message = "账单id不能为空")
    @Min(value = 0, message = "账单id不能小于0")
    private Long id;

}
