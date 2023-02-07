package com.nero.hua.convert;

import com.nero.hua.bean.TagDO;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.model.tag.TagUpdateRequest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TagConvert {

    public static TagDO convertRequestToDO(TagAddRequest tagAddRequest, Long userId) {
        TagDO tagDO = new TagDO();

        tagDO.setCreateUserId(userId);
        tagDO.setUpdateUserId(userId);
        tagDO.setCreateTime(new Date());
        tagDO.setUpdateTime(new Date());

        tagDO.setCode(tagAddRequest.getCode());
        tagDO.setName(tagAddRequest.getName());
        tagDO.setDescription(tagAddRequest.getDescription());
        tagDO.setParentId(tagAddRequest.getParentId());

        return tagDO;
    }

    public static TagDO convertRequestToDO(TagUpdateRequest tagUpdateRequest, Long userId) {
        TagDO tagDO = new TagDO();

        tagDO.setId(tagUpdateRequest.getId());
        tagDO.setUpdateUserId(userId);
        tagDO.setUpdateTime(new Date());

        tagDO.setCode(tagUpdateRequest.getCode());
        tagDO.setName(tagUpdateRequest.getName());
        tagDO.setDescription(tagUpdateRequest.getDescription());
        tagDO.setParentId(tagUpdateRequest.getParentId());

        return tagDO;
    }

    public static TagResponse convertDOToResponse(TagDO tagDO) {
        TagResponse tagResponse = new TagResponse();

        tagResponse.setCreateUserId(tagDO.getCreateUserId());
        tagResponse.setUpdateUserId(tagDO.getUpdateUserId());
        tagResponse.setCreateTime(tagDO.getCreateTime());
        tagResponse.setUpdateTime(tagDO.getUpdateTime());

        tagResponse.setCode(tagDO.getCode());
        tagResponse.setName(tagDO.getName());
        tagResponse.setDescription(tagDO.getDescription());
        tagResponse.setParentId(tagDO.getParentId());

        return tagResponse;
    }

    public static List<TagResponse> convertDOToResponse(List<TagDO> tagDOList) {
        if (CollectionUtils.isEmpty(tagDOList)) {
            return null;
        }

        List<TagResponse> tagResponseList = new ArrayList<>();
        for (TagDO tagDO : tagDOList) {
            tagResponseList.add(convertDOToResponse(tagDO));
        }

        return tagResponseList;
    }
}
