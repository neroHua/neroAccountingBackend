package com.nero.hua.convert;

import com.nero.hua.bean.TagDO;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagResponse;

public class TagConvert {

    public static TagDO convertRequestToDO(TagAddRequest tagAddRequest) {
        TagDO tagDO = new TagDO();
        return tagDO;
    }

    public static TagResponse convertDOToResponse(TagDO tagDO) {
        TagResponse tagResponse = new TagResponse();
        return tagResponse;
    }
}
