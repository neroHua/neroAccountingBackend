package com.nero.hua.service.impl;

import com.nero.hua.bean.AccountingDO;
import com.nero.hua.bean.AccountingTagDO;
import com.nero.hua.bean.UserDO;
import com.nero.hua.convert.AccountingConvert;
import com.nero.hua.convert.AccountingTagConvert;
import com.nero.hua.dao.AccountingDAO;
import com.nero.hua.dao.AccountingTagDAO;
import com.nero.hua.dao.UserDAO;
import com.nero.hua.model.accounting.AccountingAddRequest;
import com.nero.hua.model.accounting.AccountingPageRequest;
import com.nero.hua.model.accounting.AccountingResponse;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class AccountingServiceImpl implements AccountingService {

    @Autowired
    private AccountingDAO accountingDAO;

    @Autowired
    private AccountingTagDAO accountingTagDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public Long add(AccountingAddRequest accountingAddRequest, String userId) {
        UserDO userDO = userDAO.selectByUserId(userId);
        AccountingDO accountingDO = AccountingConvert.convertRequestToDO(accountingAddRequest, userDO.getId());
        long accountingDOId = accountingDAO.insertAccounting(accountingDO);

        List<Long> tagIdList = accountingAddRequest.getTagIdList();
        if (CollectionUtils.isEmpty(tagIdList)) {
            return accountingDOId;
        }

        for (long tagId : tagIdList) {
            AccountingTagDO accountingTagDO = AccountingTagConvert.convertDO(userDO.getId(), accountingDOId, tagId);
            accountingTagDAO.insertAccountingTag(accountingTagDO);
        }

        return accountingDOId;
    }

    @Override
    public AccountingResponse get(Long id) {
        AccountingDO accountingDO = accountingDAO.selectById(id);
        return AccountingConvert.convertDOToResponse(accountingDO);
    }

    @Override
    public BasePageResponse<AccountingResponse> selectByPage(AccountingPageRequest accountingPageRequest) {
        Long totalCount = accountingDAO.selectCountByPage(accountingPageRequest);
        List<AccountingDO> accountingDOList = accountingDAO.selectListByPage(accountingPageRequest, accountingPageRequest.calculateBegin());

        List<AccountingResponse> newsResponseList = AccountingConvert.convertDOToResponse(accountingDOList);

        return new BasePageResponse<>(totalCount, newsResponseList);
    }

}
