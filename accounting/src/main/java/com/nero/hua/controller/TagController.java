package com.nero.hua.controller;

import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagPageRequest;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.model.tag.TagUpdateRequest;
import com.nero.hua.service.TagService;
import com.nero.hua.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping
    public BaseResponse<Long> add(@RequestBody @Validated TagAddRequest tagAddRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        Long id = tagService.add(tagAddRequest, userId);

        return new BaseResponse<>(id);
    }

    @DeleteMapping(value = "/{id}")
    public BaseResponse<Long> delete(@PathVariable(name = "id") Long id) {
        Long changeCount = tagService.deleteById(id);

        return new BaseResponse<>(changeCount);
    }

    @PutMapping
    public BaseResponse<Long> update(@RequestBody @Validated TagUpdateRequest tagUpdateRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        Long updateCount = tagService.updateById(tagUpdateRequest, userId);

        return new BaseResponse<>(updateCount);
    }

    @GetMapping(value = "/detail/{id}")
    public BaseResponse<TagResponse> get(@PathVariable(name = "id") Long id) {
        TagResponse tagResponse = tagService.get(id);

        return new BaseResponse<>(tagResponse);
    }

    @GetMapping(value = "/list")
    public BaseResponse<BasePageResponse<TagResponse>> selectTagByPage(@Validated TagPageRequest tagPageRequest) {
        BasePageResponse<TagResponse> tagPageResponse = tagService.selectByPage(tagPageRequest);
        return new BaseResponse(tagPageResponse);
    }

}
