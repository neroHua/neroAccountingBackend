package com.nero.hua.dao;

import com.nero.hua.bean.AccountingDO;
import org.apache.ibatis.annotations.Param;

public interface AccountingDAO {
    Long insertAccounting(@Param("accountingDO") AccountingDO accountingDO);

    AccountingDO selectById(@Param("id") Long id);
}