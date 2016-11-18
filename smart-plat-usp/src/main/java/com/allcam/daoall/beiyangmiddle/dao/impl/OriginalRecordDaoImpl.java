package com.allcam.daoall.beiyangmiddle.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.beiyangmiddle.dao.OriginalRecordDao;
import com.allcam.pojo.OriginalRecordInfo;

@Repository
public class OriginalRecordDaoImpl extends BaseDao<Object> implements OriginalRecordDao
{
    
    public static final Log LOG = LogFactory.getLog(OriginalRecordDaoImpl.class);
    
    @Override
    public List<OriginalRecordInfo> getOriginalRecordInfo(OriginalRecordInfo originalRecordInfo)
    {
        SqlSession sqlSession = getSqlSession();
        List<OriginalRecordInfo> result = sqlSession.selectList("OriginalRecordInfo.queryOriginalRecordInfo", originalRecordInfo);
        return result;
    }
}
