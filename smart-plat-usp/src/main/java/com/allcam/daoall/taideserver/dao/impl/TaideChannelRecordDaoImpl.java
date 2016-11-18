package com.allcam.daoall.taideserver.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.taideserver.dao.TaideChannelRecordDao;
import com.allcam.pojo.TaideChannelRecordInfo;

@Repository
public class TaideChannelRecordDaoImpl extends BaseDao<Object> implements TaideChannelRecordDao
{
    
    public static final Log LOG = LogFactory.getLog(TaideChannelRecordDaoImpl.class);
    
    @Override
    public List<TaideChannelRecordInfo> getChannelRecordInfo(TaideChannelRecordInfo taideChannelRecordInfo)
    {
        SqlSession sqlSession = getSqlSession();
        List<TaideChannelRecordInfo> result =
            sqlSession.selectList("TaideChannelRecordInfo.queryTaideChannelRecordInfo", taideChannelRecordInfo);
        return result;
    }
}
