package com.nero.hua.model.tag;

import com.nero.hua.model.base.BasePageRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Getter
@Setter
public class TagPageRequest extends BasePageRequest {

    @Length(max = 32, message = "编码字长不能超过32")
    private String codeLike;

    @Length(max = 32, message = "编码字长不能超过32")
    private String codeEqual;

    @Length(max = 32, message = "名称字长不能超过32")
    private String nameLike;

    @Length(max = 32, message = "名称字长不能超过32")
    private String nameEqual;

    @Min(value = 0, message = "父标签id不能小于0")
    private Long parentId;
}
