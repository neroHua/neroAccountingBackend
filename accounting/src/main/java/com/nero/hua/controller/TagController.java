package com.nero.hua.controller;

import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping
    public BaseResponse<Long> add(@RequestBody @Validated TagAddRequest tagAddRequest) {
        Long id = tagService.add(tagAddRequest);

        return new BaseResponse<>(id);
    }

    @GetMapping(value = "/detail/{id}")
    public BaseResponse<TagResponse> get(@PathVariable(name = "id") Long id) {
        TagResponse tagResponse = tagService.get(id);

        return new BaseResponse<>(tagResponse);
    }

}
