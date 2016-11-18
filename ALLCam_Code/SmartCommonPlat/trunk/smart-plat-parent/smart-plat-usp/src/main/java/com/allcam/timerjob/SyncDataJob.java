package com.allcam.timerjob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.allcam.daoall.agent.dao.SchoolDao;
import com.allcam.modules.sysncdataservice.inf.SyncDataService;
import com.allcam.pojo.PageBean;
import com.allcam.pojo.SchoolInfo;

/**
 * 同步学校的定时任务
 * 
 * @version [版本号, Aug 28, 2015]
 */
@Component("SyncDataJobTask")
public class SyncDataJob
{
    public static final Log LOG = LogFactory.getLog(SyncDataJob.class);
    
    @Resource
    private SyncDataService syncDataService;
    
    @Resource
    private SchoolDao schoolDao;
    
    public void syncDataJob()
    {
        try
        {
            syncDataService.syncSchool("","", "");
            Map<String, Object> map = new HashMap<String, Object>();
            SchoolInfo schoolInfo = new SchoolInfo();
            PageBean pageBean = new PageBean();
            pageBean.setPageNo(1);
            pageBean.setPageSize(1000);
            map.put("pageBean", pageBean);
            map.put("schoolInfo", schoolInfo);
            List<SchoolInfo> school = schoolDao.querySchoolInfoByCer(map);
            for (int i = 0; i < school.size(); i++)
            {
                syncDataService.syncTeacher("",school.get(i).getSchoolId());
                syncDataService.syncStudent("",school.get(i).getSchoolId());
            }
        }
        catch (Exception e)
        {
            LOG.error("Exception", e);
        }
    }
}
