package com.nero.hua.service;

import com.nero.hua.model.accounting.AccountingAddRequest;
import com.nero.hua.model.accounting.AccountingPageRequest;
import com.nero.hua.model.accounting.AccountingResponse;
import com.nero.hua.model.accounting.AccountingTagListRequest;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.tag.TagResponse;

import java.util.List;

public interface AccountingService {

    Long add(AccountingAddRequest accountingAddRequest, String userId);

    AccountingResponse get(Long id);

    BasePageResponse<AccountingResponse> selectByPage(AccountingPageRequest accountingPageRequest);

    List<TagResponse> selectAccountingTagList(AccountingTagListRequest accountingTagRequest);
}
