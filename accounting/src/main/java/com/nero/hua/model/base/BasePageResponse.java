package com.nero.hua.model.base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasePageResponse <T> {

    private Long totalCount;

    private List<T> dataList;

    public BasePageResponse(Long totalCount, List<T> dataList) {
        this.totalCount = totalCount;
        this.dataList = dataList;
    }
}
