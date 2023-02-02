package com.nero.hua.service;

import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagResponse;

public interface TagService {

    Long add(TagAddRequest tagAddRequest);

    TagResponse get(Long id);

}
