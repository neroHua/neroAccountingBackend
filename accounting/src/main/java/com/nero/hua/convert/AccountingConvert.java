package com.nero.hua.convert;

import com.nero.hua.bean.AccountingDO;
import com.nero.hua.model.accounting.AccountingAddRequest;
import com.nero.hua.model.accounting.AccountingResponse;
import com.nero.hua.model.accounting.AccountingUpdateRequest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountingConvert {
    public static AccountingDO convertRequestToDO(AccountingAddRequest accountingAddRequest, long userId) {
        AccountingDO accountingDO = new AccountingDO();

        accountingDO.setCreateUserId(userId);
        accountingDO.setUpdateUserId(userId);
        accountingDO.setCreateTime(new Date());
        accountingDO.setUpdateTime(new Date());

        accountingDO.setUserId(userId);
        accountingDO.setBillCreateTime(accountingAddRequest.getBillCreateTime());
        accountingDO.setBillMoney(accountingAddRequest.getBillMoney());
        accountingDO.setDescription(accountingAddRequest.getDescription());

        accountingDO.setReviewDescription(accountingAddRequest.getReviewDescription());
        accountingDO.setValuable(accountingAddRequest.getValuable());

        return accountingDO;
    }

    public static AccountingDO convertRequestToDO(AccountingUpdateRequest accountingUpdateRequest, Long userId) {
        AccountingDO accountingDO = new AccountingDO();

        accountingDO.setId(accountingUpdateRequest.getId());
        accountingDO.setUpdateUserId(userId);
        accountingDO.setUpdateTime(new Date());

        accountingDO.setBillCreateTime(accountingUpdateRequest.getBillCreateTime());
        accountingDO.setBillMoney(accountingUpdateRequest.getBillMoney());
        accountingDO.setDescription(accountingUpdateRequest.getDescription());
        accountingDO.setReviewDescription(accountingUpdateRequest.getReviewDescription());

        accountingDO.setValuable(accountingUpdateRequest.getValuable());

        return accountingDO;
    }

    public static AccountingResponse convertDOToResponse(AccountingDO accountingDO) {
        AccountingResponse accountingResponse = new AccountingResponse();

        accountingResponse.setCreateUserId(accountingDO.getCreateUserId());
        accountingResponse.setUpdateUserId(accountingDO.getUpdateUserId());
        accountingResponse.setCreateTime(accountingDO.getCreateTime());
        accountingResponse.setUpdateTime(accountingDO.getUpdateTime());

        accountingResponse.setUserId(accountingDO.getUserId());
        accountingResponse.setBillCreateTime(accountingDO.getBillCreateTime());
        accountingResponse.setBillMoney(accountingDO.getBillMoney());
        accountingResponse.setDescription(accountingDO.getDescription());

        accountingResponse.setReviewDescription(accountingDO.getReviewDescription());
        accountingResponse.setValuable(accountingDO.getValuable());

        return accountingResponse;
    }

    public static List<AccountingResponse> convertDOToResponse(List<AccountingDO> accountingDOList) {
        if (CollectionUtils.isEmpty(accountingDOList)) {
            return null;
        }

        List<AccountingResponse> accountingResponseList = new ArrayList<>();
        for (AccountingDO accountingDO : accountingDOList) {
            accountingResponseList.add(convertDOToResponse(accountingDO));
        }

        return accountingResponseList;
    }
}
