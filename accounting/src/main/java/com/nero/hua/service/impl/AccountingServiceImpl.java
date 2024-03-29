package com.nero.hua.service.impl;

import com.nero.hua.bean.AccountingDO;
import com.nero.hua.bean.AccountingTagDO;
import com.nero.hua.bean.TagDO;
import com.nero.hua.bean.UserDO;
import com.nero.hua.convert.AccountingConvert;
import com.nero.hua.convert.AccountingTagConvert;
import com.nero.hua.convert.TagConvert;
import com.nero.hua.dao.AccountingDAO;
import com.nero.hua.dao.AccountingTagDAO;
import com.nero.hua.dao.TagDAO;
import com.nero.hua.dao.UserDAO;
import com.nero.hua.model.accounting.*;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService {

    @Autowired
    private AccountingDAO accountingDAO;

    @Autowired
    private AccountingTagDAO accountingTagDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TagDAO tagDAO;

    @Override
    @Transactional
    public Long add(AccountingAddRequest accountingAddRequest, String userId) {
        UserDO userDO = userDAO.selectByUserId(userId);
        AccountingDO accountingDO = AccountingConvert.convertRequestToDO(accountingAddRequest, userDO.getId());
        accountingDAO.insertAccounting(accountingDO);

        long accountingDOId = accountingDO.getId();

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
    @Transactional
    public Long addList(List<AccountingAddRequest> accountingAddRequestList, String userId) {
        for (AccountingAddRequest accountingAddRequest : accountingAddRequestList) {
            add(accountingAddRequest, userId);
        }
        return null;
    }

    @Override
    public Long deleteById(Long id) {
        accountingTagDAO.deleteByAccountingId(id);
        return accountingDAO.deleteById(id);
    }

    @Override
    public Long updateById(AccountingUpdateRequest accountingUpdateRequest, String userId) {
        UserDO userDO = userDAO.selectByUserId(userId);
        AccountingDO accountingDO = AccountingConvert.convertRequestToDO(accountingUpdateRequest, userDO.getId());
        return accountingDAO.updateById(accountingDO);
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

    @Override
    public Long addAccountingTag(AccountingTagAddRequest accountingTagAddRequest, String userId) {
        UserDO userDO = userDAO.selectByUserId(userId);
        AccountingTagDO accountingTagDO = AccountingTagConvert.convertRequestToDO(accountingTagAddRequest, userDO.getId());
        accountingTagDAO.insertAccountingTag(accountingTagDO);
        return accountingTagDO.getId();
    }

    @Override
    public Long deleteAccountingTag(AccountingTagDeleteRequest accountingTagdeleteRequest) {
        return accountingTagDAO.deleteByAccountingIdAndTagId(accountingTagdeleteRequest.getAccountingId(), accountingTagdeleteRequest.getTagId());
    }

    @Override
    public List<TagResponse> selectAccountingTagList(AccountingTagListRequest accountingTagListRequest) {
        List<AccountingTagDO> accountingTagDOList = accountingTagDAO.selectListByAccountingId(accountingTagListRequest.getId());

        if (CollectionUtils.isEmpty(accountingTagDOList)) {
            return null;
        }

        List<TagDO> tagDOList = new ArrayList<>();
        for (AccountingTagDO accountingTagDO : accountingTagDOList) {
            tagDOList.add(tagDAO.selectById(accountingTagDO.getTagId()));
        }

        return TagConvert.convertDOToResponse(tagDOList);
    }

}
