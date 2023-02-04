package com.nero.hua.model.tag;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TagAddRequest {
    @NotNull(message = "编码不能为空")
    @NotBlank(message = "编码不能为空")
    @Length(max = 32, message = "编码字长不能超过32")
    private String code;

    @NotNull(message = "名称不能为空")
    @NotBlank(message = "名称不能为空")
    @Length(max = 32, message = "名称字长不能超过32")
    private String name;

    @Length(max = 64, message = "描述字长不能超过64")
    private String description;

    @Min(value = 0, message = "父标签id不能小于0")
    private Long parentId;
}
