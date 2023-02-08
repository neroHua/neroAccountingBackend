package com.nero.hua.dao;

import com.nero.hua.bean.AccountingDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountingDAOTest {

    @Autowired
    private AccountingDAO accountingDAO;

    @Test
    public void testCRUD() {
        AccountingDO accountingDO = new AccountingDO();
        accountingDO.setCreateTime(new Date());
        accountingDO.setUpdateTime(new Date());
        accountingDO.setCreateUserId(0L);
        accountingDO.setUpdateUserId(0L);

        accountingDO.setUserId(1L);

        accountingDO.setBillMoney(100D);
        accountingDO.setBillCreateTime(new Date());
        accountingDO.setDescription("huadeyouTestDescription001");
        accountingDO.setReviewDescription("huadeyouTestReviewDescription001");
        accountingDO.setValuable(Boolean.TRUE);

        Long id = accountingDAO.insertAccounting(accountingDO);
        Assert.assertTrue("插入标签应该成功", id > 0);

        AccountingDO accountingDO1 = accountingDAO.selectById(accountingDO.getId());
        testDOEqual(accountingDO, accountingDO1);

        accountingDO.setUpdateUserId(2L);
        accountingDO.setUpdateTime(new Date());
        accountingDO.setBillMoney(1000D);
        accountingDO.setBillCreateTime(new Date());
        accountingDO.setDescription("huadeyouTestDescription002");
        accountingDO.setReviewDescription("huadeyouTestReviewDescription002");
        accountingDO.setValuable(Boolean.FALSE);
        accountingDAO.updateById(accountingDO);
        AccountingDO accountingDO2 = accountingDAO.selectById(accountingDO.getId());
        testDOEqual(accountingDO, accountingDO2);

        accountingDAO.deleteById(accountingDO.getId());

        AccountingDO accountingDO3 = accountingDAO.selectById(accountingDO.getId());
        Assert.assertNull( "应该找不到标签", accountingDO3);
    }

    private static void testDOEqual(AccountingDO accountingDO, AccountingDO accountingDO1) {
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getCreateUserId(), accountingDO.getCreateUserId());
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getUpdateUserId(), accountingDO.getUpdateUserId());
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getUserId(), accountingDO.getUserId());
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getBillMoney(), accountingDO.getBillMoney());
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getDescription(), accountingDO.getDescription());
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getReviewDescription(), accountingDO.getReviewDescription());
        Assert.assertEquals("插入前后字段应该相等", accountingDO1.getValuable(), accountingDO.getValuable());
    }

}
