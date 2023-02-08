package com.nero.hua.convert;

import com.nero.hua.bean.AccountingTagDO;
import com.nero.hua.model.accounting.AccountingTagAddRequest;

import java.util.Date;

public class AccountingTagConvert {

    public static AccountingTagDO convertRequestToDO(AccountingTagAddRequest accountingTagAddRequest, Long userId) {
        return convertDO(userId, accountingTagAddRequest.getAccountingId(), accountingTagAddRequest.getTagId());
    }

    public static AccountingTagDO convertDO(Long userId, long accountingDOId, long tagId) {
        AccountingTagDO accountingTagDO = new AccountingTagDO();

        accountingTagDO.setCreateUserId(userId);
        accountingTagDO.setUpdateUserId(userId);
        accountingTagDO.setCreateTime(new Date());
        accountingTagDO.setUpdateTime(new Date());

        accountingTagDO.setAccountingId(accountingDOId);
        accountingTagDO.setTagId(tagId);

        return accountingTagDO;
    }

}
