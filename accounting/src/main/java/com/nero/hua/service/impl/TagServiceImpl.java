package com.nero.hua.service.impl;

import com.nero.hua.bean.TagDO;
import com.nero.hua.bean.UserDO;
import com.nero.hua.convert.TagConvert;
import com.nero.hua.dao.AccountingDAO;
import com.nero.hua.dao.TagDAO;
import com.nero.hua.dao.UserDAO;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagPageRequest;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagServiceImpl implements TagService {

    @Autowired
    TagDAO tagDAO;

    @Autowired
    AccountingDAO accountingDAO;

    @Autowired
    UserDAO userDAO;

    @Override
    public Long add(TagAddRequest tagAddRequest, String userId) {
        UserDO userDO = userDAO.selectByUserId(userId);
        TagDO tagDO = TagConvert.convertRequestToDO(tagAddRequest, userDO.getId());
        return tagDAO.insertTag(tagDO);
    }

    @Override
    public TagResponse get(Long id) {
        TagDO tagDO = tagDAO.selectById(id);
        return TagConvert.convertDOToResponse(tagDO);
    }

    @Override
    public BasePageResponse<TagResponse> selectByPage(TagPageRequest tagPageRequest) {
        Long totalCount = tagDAO.selectCountByPage(tagPageRequest);
        List<TagDO> tagDOList = tagDAO.selectListByPage(tagPageRequest, tagPageRequest.calculateBegin());

        List<TagResponse> newsResponseList = TagConvert.convertDOToResponse(tagDOList);

        return new BasePageResponse<>(totalCount, newsResponseList);
    }

}