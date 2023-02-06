package com.nero.hua.dao;

import com.nero.hua.bean.TagDO;
import com.nero.hua.model.tag.TagPageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDAO {
    Long insertTag(@Param("tagDO") TagDO tagDO);

    TagDO selectById(@Param("id") Long id);

    Long selectCountByPage(@Param("tagPageRequest") TagPageRequest tagPageRequest);

    List<TagDO> selectListByPage(@Param("tagPageRequest") TagPageRequest tagPageRequest, @Param("begin") Long calculateBegin);
}
