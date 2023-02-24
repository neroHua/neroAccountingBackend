package com.nero.hua.model.base;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class BasePageRequest {

    @NotNull(message = "每页数量不能为null")
    @Min(value = 0, message = "每页数量不能小于0")
    private Integer pageSize;
    @NotNull(message = "页码不能为null")
    @Min(value = 0, message = "页码不能小于0")
    private Integer pageNumber;

    private String keyword;

    public Long calculateBegin() {
        return (long) (pageNumber - 1) * pageSize;
    }
}
