package com.nero.hua.service;

import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagPageRequest;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.model.tag.TagUpdateRequest;

public interface TagService {

    Long add(TagAddRequest tagAddRequest, String userId);

    long deleteById(Long id);

    long updateById(TagUpdateRequest tagUpdateRequest, String userId);

    TagResponse get(Long id);

    BasePageResponse<TagResponse> selectByPage(TagPageRequest tagPageRequest);

}
