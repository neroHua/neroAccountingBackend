package com.nero.hua.dao;

import com.nero.hua.bean.AccountingTagDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountingTagDAO {

    Long insertAccountingTag(@Param("accountingTagDO") AccountingTagDO accountingTagDO);

    AccountingTagDO selectById(@Param("id") Long id);

    List<AccountingTagDO> selectListByAccountingId(@Param("accountingId") Long accountingId);

    long selectCountByTagId(@Param("tagId") Long tagId);
}
