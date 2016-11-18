package com.allcam.daoall;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础DAO
 * 
 * @author YiZhichao
 * @version [版本号, 2015-5-11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class BaseDao<T> extends SqlSessionDaoSupport
{
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
    
    protected <S> S getMapper(Class<S> clazz)
    {
        return getSqlSession().getMapper(clazz);
    }
}