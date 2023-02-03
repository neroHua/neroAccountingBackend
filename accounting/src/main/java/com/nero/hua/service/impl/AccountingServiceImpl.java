package com.nero.hua.service.impl;

import com.nero.hua.dao.AccountingDAO;
import com.nero.hua.dao.AccountingTagDAO;
import com.nero.hua.model.accounting.AccountingAddRequest;
import com.nero.hua.model.accounting.AccountingResponse;
import com.nero.hua.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountingServiceImpl implements AccountingService {

    @Autowired
    private AccountingDAO accountingDAO;

    @Autowired
    private AccountingTagDAO accountingTagDAO;

    @Override
    public Long add(AccountingAddRequest accountingAddRequest) {
        return null;
    }

    @Override
    public AccountingResponse get(Long id) {
        return null;
    }

}
