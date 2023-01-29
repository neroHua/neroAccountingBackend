package com.nero.hua.model.base;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasePageRequest {

    private Integer pageSize;

    private Integer pageNumber;

    private String keyword;

    public Long calculateBegin() {
        return (long) (pageNumber - 1) * pageSize;
    }
}
