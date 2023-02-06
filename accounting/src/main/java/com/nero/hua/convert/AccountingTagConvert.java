package com.nero.hua.convert;

import com.nero.hua.bean.AccountingTagDO;

import java.util.Date;

public class AccountingTagConvert {

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
