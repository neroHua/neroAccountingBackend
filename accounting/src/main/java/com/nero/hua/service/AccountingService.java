package com.nero.hua.service;

import com.nero.hua.model.accounting.AccountingAddRequest;
import com.nero.hua.model.accounting.AccountingResponse;

public interface AccountingService {

    Long add(AccountingAddRequest accountingAddRequest);

    AccountingResponse get(Long id);

}
