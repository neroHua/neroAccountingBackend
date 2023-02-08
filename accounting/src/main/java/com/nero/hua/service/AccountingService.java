package com.nero.hua.service;

import com.nero.hua.model.accounting.*;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.tag.TagResponse;

import java.util.List;

public interface AccountingService {

    Long add(AccountingAddRequest accountingAddRequest, String userId);

    Long deleteById(Long id);

    Long updateById(AccountingUpdateRequest accountingUpdateRequest, String userId);

    AccountingResponse get(Long id);

    BasePageResponse<AccountingResponse> selectByPage(AccountingPageRequest accountingPageRequest);

    Long addAccountingTag(AccountingTagAddRequest accountingTagAddRequest, String userId);

    Long deleteAccountingTag(AccountingTagDeleteRequest accountingTagdeleteRequest);

    List<TagResponse> selectAccountingTagList(AccountingTagListRequest accountingTagListRequest);
}
