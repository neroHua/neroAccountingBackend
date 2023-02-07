package com.nero.hua.service;

import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagPageRequest;
import com.nero.hua.model.tag.TagResponse;

public interface TagService {

    Long add(TagAddRequest tagAddRequest, String userId);

    void deleteById(Long id);

    TagResponse get(Long id);

    BasePageResponse<TagResponse> selectByPage(TagPageRequest tagPageRequest);
}
