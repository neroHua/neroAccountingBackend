package com.nero.hua.controller;

import com.nero.hua.model.accounting.AccountingAddRequest;
import com.nero.hua.model.accounting.AccountingResponse;
import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounting")
public class AccountingController {

    @Autowired
    AccountingService accountingService;

    @PostMapping
    public BaseResponse<Long> add(@RequestBody @Validated AccountingAddRequest accountingAddRequest) {
        Long id = accountingService.add(accountingAddRequest);

        return new BaseResponse<>(id);
    }

    @GetMapping(value = "/detail/{id}")
    public BaseResponse<AccountingResponse> get(@PathVariable(name = "id") Long id) {
        AccountingResponse accountingResponse = accountingService.get(id);

        return new BaseResponse<>(accountingResponse);
    }

}
