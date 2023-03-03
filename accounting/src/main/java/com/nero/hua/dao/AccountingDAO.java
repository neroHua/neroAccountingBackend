package com.nero.hua.dao;

import com.nero.hua.bean.AccountingDO;
import com.nero.hua.model.accounting.AccountingPageRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthRequest;
import com.nero.hua.model.statisticsAndAnalysis.TotalMoneyForEveryMonthResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountingDAO {

    Long insertAccounting(@Param("accountingDO") AccountingDO accountingDO);

    Long deleteById(@Param("id") Long id);

    Long updateById(@Param("accountingDO") AccountingDO accountingDO);

    AccountingDO selectById(@Param("id") Long id);

    Long selectCountByPage(@Param("accountingPageRequest") AccountingPageRequest accountingPageRequest);

    List<AccountingDO> selectListByPage(@Param("accountingPageRequest") AccountingPageRequest accountingPageRequest, @Param("begin") Long calculateBegin);

    List<TotalMoneyForEveryMonthResponse> getTotalMoneyForEveryMonth(@Param("totalMoneyForEveryMonthRequest") TotalMoneyForEveryMonthRequest totalMoneyForEveryMonthRequest);
}
