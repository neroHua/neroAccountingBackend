package com.nero.hua.dao;

import com.nero.hua.bean.AccountingTagDO;
import org.apache.ibatis.annotations.Param;

public interface AccountingTagDAO {
    Long insertAccountingTag(@Param("accountingTagDO") AccountingTagDO accountingTagDO);

    AccountingTagDO selectById(@Param("id") Long id);
}