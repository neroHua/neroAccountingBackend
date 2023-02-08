package com.nero.hua.controller;

import com.nero.hua.model.accounting.*;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.service.AccountingService;
import com.nero.hua.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("accounting")
public class AccountingController {

    @Autowired
    AccountingService accountingService;

    @PostMapping
    public BaseResponse<Long> add(@RequestBody @Validated AccountingAddRequest accountingAddRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        Long id = accountingService.add(accountingAddRequest, userId);

        return new BaseResponse<>(id);
    }

    @DeleteMapping(value = "/{id}")
    public BaseResponse<Long> delete(@PathVariable(name = "id") Long id) {
        Long changeCount = accountingService.deleteById(id);

        return new BaseResponse<>(changeCount);
    }

    @PutMapping
    public BaseResponse<Long> update(@RequestBody @Validated AccountingUpdateRequest accountingUpdateRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        Long updateCount = accountingService.updateById(accountingUpdateRequest, userId);

        return new BaseResponse<>(updateCount);
    }

    @GetMapping(value = "/detail/{id}")
    public BaseResponse<AccountingResponse> get(@PathVariable(name = "id") Long id) {
        AccountingResponse accountingResponse = accountingService.get(id);

        return new BaseResponse<>(accountingResponse);
    }

    @GetMapping(value = "/list")
    public BaseResponse<BasePageResponse<AccountingResponse>> selectAccountingByPage(@RequestBody @Validated AccountingPageRequest accountingPageRequest) {
        BasePageResponse<AccountingResponse> accountingPageResponse = accountingService.selectByPage(accountingPageRequest);
        return new BaseResponse(accountingPageResponse);
    }

    @PostMapping(value = "/tag")
    public BaseResponse<Long> addAccountingTag(@RequestBody @Validated AccountingTagAddRequest accountingTagAddRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);
        Long id = accountingService.addAccountingTag(accountingTagAddRequest, userId);
        return new BaseResponse(id);
    }

    @DeleteMapping(value = "/tag")
    public BaseResponse<List<Long>> deleteAccountingTag(@RequestBody @Validated AccountingTagDeleteRequest accountingTagdeleteRequest) {
        Long count = accountingService.deleteAccountingTag(accountingTagdeleteRequest);
        return new BaseResponse(count);
    }

    @GetMapping(value = "/tag/list")
    public BaseResponse<List<TagResponse>> selectAccountingTagList(@RequestBody @Validated AccountingTagListRequest accountingTagListRequest) {
        List<TagResponse> tagListResponse = accountingService.selectAccountingTagList(accountingTagListRequest);
        return new BaseResponse(tagListResponse);
    }

}
