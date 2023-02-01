package com.nero.hua.dao;

import com.nero.hua.bean.TagDO;
import org.apache.ibatis.annotations.Param;

public interface TagDAO {
    Long insertTag(@Param("tagDO") TagDO tagDO);

    TagDO selectById(@Param("id") Long id);
}