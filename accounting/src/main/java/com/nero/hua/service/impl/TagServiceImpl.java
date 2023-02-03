package com.nero.hua.service.impl;

import com.nero.hua.bean.TagDO;
import com.nero.hua.convert.TagConvert;
import com.nero.hua.dao.AccountingDAO;
import com.nero.hua.dao.TagDAO;
import com.nero.hua.model.tag.TagAddRequest;
import com.nero.hua.model.tag.TagResponse;
import com.nero.hua.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

public class TagServiceImpl implements TagService {

    @Autowired
    TagDAO tagDAO;

    @Autowired
    AccountingDAO accountingDAO;

    @Override
    public Long add(TagAddRequest tagAddRequest) {
        TagDO tagDO = TagConvert.convertRequestToDO(tagAddRequest);
        return tagDAO.insertTag(tagDO);
    }

    @Override
    public TagResponse get(Long id) {
        TagDO tagDO = tagDAO.selectById(id);
        return TagConvert.convertDOToResponse(tagDO);
    }

}
