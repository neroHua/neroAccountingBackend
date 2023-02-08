package com.nero.hua.dao;

import com.nero.hua.bean.TagDO;
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
public class TagDAOTest {

    @Autowired
    private TagDAO tagDAO;

    @Test
    public void testCRUD() {
        TagDO tagDO = new TagDO();
        tagDO.setCreateTime(new Date());
        tagDO.setUpdateTime(new Date());
        tagDO.setCreateUserId(0L);
        tagDO.setUpdateUserId(0L);
        tagDO.setCode("huadeyouTestCode001");
        tagDO.setName("huadeyouTestName001");
        tagDO.setDescription("huadeyouTestDescription001");
        tagDO.setParentId(1L);
        Long id = tagDAO.insertTag(tagDO);
        Assert.assertTrue("插入标签应该成功", id > 0);

        TagDO tagDO1 = tagDAO.selectById(tagDO.getId());
        Assert.assertEquals("插入前后字段应该相等", tagDO1.getCreateUserId(), tagDO.getCreateUserId());
        Assert.assertEquals("插入前后字段应该相等", tagDO1.getUpdateUserId(), tagDO.getUpdateUserId());
        Assert.assertEquals("插入前后字段应该相等", tagDO1.getCode(), tagDO.getCode());
        Assert.assertEquals("插入前后字段应该相等", tagDO1.getName(), tagDO.getName());
        Assert.assertEquals("插入前后字段应该相等", tagDO1.getDescription(), tagDO.getDescription());
        Assert.assertEquals("插入前后字段应该相等", tagDO1.getParentId(), tagDO.getParentId());

        tagDO.setUpdateUserId(2L);
        tagDO.setUpdateTime(new Date());
        tagDO.setCode("huadeyouTestCode002");
        tagDO.setName("huadeyouTestName002");
        tagDO.setDescription("huadeyouTestDescription002");
        tagDO.setParentId(2L);
        tagDAO.updateById(tagDO);
        TagDO tagDO2 = tagDAO.selectById(tagDO.getId());
        Assert.assertEquals("插入前后字段应该相等", tagDO2.getUpdateUserId(), tagDO.getUpdateUserId());
        Assert.assertEquals("插入前后字段应该相等", tagDO2.getCode(), tagDO.getCode());
        Assert.assertEquals("插入前后字段应该相等", tagDO2.getName(), tagDO.getName());
        Assert.assertEquals("插入前后字段应该相等", tagDO2.getDescription(), tagDO.getDescription());
        Assert.assertEquals("插入前后字段应该相等", tagDO2.getParentId(), tagDO.getParentId());

        tagDAO.deleteById(tagDO.getId());

        TagDO tagDO3 = tagDAO.selectById(tagDO.getId());
        Assert.assertNull( "应该找不到标签", tagDO3);

    }

    @Test
    public void testSelectById() {
        TagDO tagDO = tagDAO.selectById(1L);
        Assert.assertNotNull( "应该找到标签1", tagDO);

        TagDO tagDO1 = tagDAO.selectById(-1L);
        Assert.assertNull( "应该找不到标签-1", tagDO1);
    }

}
