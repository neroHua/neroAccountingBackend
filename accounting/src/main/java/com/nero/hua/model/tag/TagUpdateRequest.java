package com.nero.hua.model.tag;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TagUpdateRequest {

    @NotNull(message = "id不能为空")
    @Min(value = 0, message = "id不能小于0")
    private Long id;

    @Length(max = 32, message = "编码字长不能超过32")
    private String code;

    @Length(max = 32, message = "名称字长不能超过32")
    private String name;

    @Length(max = 64, message = "描述字长不能超过64")
    private String description;

    @Min(value = 0, message = "父标签id不能小于0")
    private Long parentId;

}
