package com.nero.hua.dao;

import com.nero.hua.bean.AccountingTagDO;
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
public class AccountingTagDAOTest {

    @Autowired
    private AccountingTagDAO accountingTagDAO;

    @Test
    public void testCRUD() {
        AccountingTagDO accountingTagDO = new AccountingTagDO();
        accountingTagDO.setCreateTime(new Date());
        accountingTagDO.setUpdateTime(new Date());
        accountingTagDO.setCreateUserId(0L);
        accountingTagDO.setUpdateUserId(0L);

        accountingTagDO.setTagId(11L);
        accountingTagDO.setAccountingId(22L);
        Long id = accountingTagDAO.insertAccountingTag(accountingTagDO);
        Assert.assertTrue("插入标签应该成功", id > 0);

        AccountingTagDO accountingTagDO1 = accountingTagDAO.selectById(accountingTagDO.getId());
        testDOEqual(accountingTagDO, accountingTagDO1);

        long count = accountingTagDAO.selectCountByTagId(accountingTagDO.getTagId());
        Assert.assertEquals("数量应该为1", 1, count);

        accountingTagDAO.deleteByAccountingId(accountingTagDO.getAccountingId());
        AccountingTagDO accountingTagDO3 = accountingTagDAO.selectById(accountingTagDO.getId());
        Assert.assertNull( "应该找不到标签", accountingTagDO3);
    }

    private static void testDOEqual(AccountingTagDO accountingTagDO, AccountingTagDO accountingTagDO1) {
        Assert.assertEquals("插入前后字段应该相等", accountingTagDO1.getCreateUserId(), accountingTagDO.getCreateUserId());
        Assert.assertEquals("插入前后字段应该相等", accountingTagDO1.getUpdateUserId(), accountingTagDO.getUpdateUserId());
        Assert.assertEquals("插入前后字段应该相等", accountingTagDO1.getTagId(), accountingTagDO.getTagId());
        Assert.assertEquals("插入前后字段应该相等", accountingTagDO1.getAccountingId(), accountingTagDO.getAccountingId());
    }

}
