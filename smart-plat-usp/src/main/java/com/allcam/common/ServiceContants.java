package com.allcam.common;

public interface ServiceContants
{
    String UTF8_CODE = "UTF-8";
    
    String TOKEN = "token";
    
    /** 老版本成功码 */
    String SUCCESS_CODE_OLD = "200";
    
    /** 成功码 */
    String SUCCESS_CODE_BPM = "200";
    
    /** 鉴权失败码 */
    String AUTH_FAIL_CODE_BPM = "401";
    
    /** 失败码 */
    String FAIL_CODE_BPM = "402";
    
    /** 其他错误 */
    String OTHER_EXCEPTION_BPM = "403";
    
    /** 数据库异常 */
    String DB_EXCEPTION_BPM = "404";
    
    /** 参数错误异常 */
    String PARAMS_ERROR_BPM = "405";
    
    /** 成功描述 */
    String SUCCESS_DES_BPM = "OK";
    
    /** 鉴权失败描述 */
    String AUTH_FAIL_DES_BPM = "Auth Fail.";
    
    /** 失败描述 */
    String FAIL_DES_BPM = "FAIL";
    
    /** 成功码 */
    String SUCCESS_CODE = "1000";
    
    /** 鉴权失败码 */
    String AUTH_FAIL_CODE = "1001";
    
    /** 失败码 */
    String FAIL_CODE = "1002";
    
    /** 其他错误 */
    String OTHER_EXCEPTION = "1003";
    
    /** 数据库异常 */
    String DB_EXCEPTION = "1004";
    
    /** HTTP异常 */
    String HTTP_EXCEPTION = "1005";
    
    /** 远程错误 */
    String REMOTE_EXCEPTION = "1006";
    
    /** 成功描述 */
    String SUCCESS_DES = "OK";
    
    /** 鉴权失败描述 */
    String AUTH_FAIL_DES = "Auth Fail.";
    
    /** 失败描述 */
    String FAIL_DES = "FAIL";
    
    /** 目录分隔符 */
    String FILE_SEAPRATOR = System.getProperty("file.separator");
    
    /** 数字1 */
    int INT_1 = 1;
    
    /** NONCE 长度34 */
    int NONCE_LENGTH = 34;
    
    /** NEXTNONCE 长度34 */
    int NEXTNONCE_LENGTH = 34;
    
    /** OPAQUE 长度34 */
    int OPAQUE_LENGTH = 34;
    
    String PIC = "PIC";
    
    /** 安全日志中的操作时间从数据库中取出的格式 */
    String LOG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.S";
    
    /** 获取学校列表 */
    String GET_SCHOOLS = "GET_SCHOOLS";
    
    String SEND_SMS_PHONES = "SEND_SMS_PHONES";
    
    String SEND_SMS_LIST = "SEND_SMS_LIST";
    
    String SEND_SMS_VALI_CODE = "SEND_SMS_VALI_CODE";
    
    String PUSH_MSG_USER = "PUSH_MSG_USER";
    
    String PUSH_MSG_USERGRP = "PUSH_MSG_USERGRP";
    
    /** 添加学校 */
    String ADD_SCHOOL = "ADD_SCHOOL";
    
    /** 修改学校 */
    String MOD_SCHOOL = "MOD_SCHOOL";
    
    /** 删除学校 */
    String DEL_SCHOOL = "DEL_SCHOOL";
    
    /** 添加用户 */
    String ADD_USER = "ADD_USER";
    
    /** 修改用户 */
    String MOD_USER = "MOD_USER";
    
    /** 删除用户 */
    String DEL_USER = "DEL_USER";
    
    /** 鉴权登录 */
    String AUTH_LOGIN = "AUTH_LOGIN";
    
    /** 关于信息 */
    String ABOUT_INFO = "ABOUT_INFO";
    
    /** 获取资源Url */
    String GET_RESOURCE = "GET_RESOURCE";
    
    /** 获取平台信息 */
    String GET_PLAT_INFO = "GET_PLAT_INFO";
    
    /** 检查系统版本 */
    String CHECK_SYS_VERSION = "CHECK_SYS_VERSION";
    
    /** 检查系统版本升级 */
    String CHECK_VERSION_UPGRADE = "CHECK_VERSION_UPGRADE";
    
    String HTTP_REQUEST = "request";
    
    String HTTP_RESPONSE = "response";
    
    String HTTP_VERSION = "1.0";
    
    String JSON_MSG_HEAD_KEY = "MsgHead";
    
    String JSON_RESULT_KEY = "Result";
    
    String JSON_MSG_BODY_KEY = "MsgBody";
    
    String JSON_MSG_PAGE = "pageInfo";
    
    String JSON_MSG_NOTICEID = "noticeId";
    
    String JSON_MSG_SERVERURL = "serverUrl";
    
    String JSON_MSG_RECOMMENDID = "recommendId";
    
    String JSON_MSG_COMMENTID = "commentId";
    
    String JSON_MSG_SMSLIST = "smsList";
    
    String CURRENT_PAGE = "1";
    
    String PAGE_SIZE = "10";
    
    /** 没找到相应的学校用户 描述 */
    String NO_CORRESPONDING_SCHUSER_DESC = "no corresponding school user found!";
    
    /** 已经点赞描述 */
    String ALREADY_PRAISED_DESC = "already_praised";
    
    /** 尚未点赞描述 */
    String NOT_YET_PRAISED_DESC = "not_yet_praised";
    
    /** 会话信息为空 */
    String SESSION_NULL_DESC = "session is null";
    
    /** 会话信息已经失效描述 */
    String SESSION_INVALIDATE_DESC = "session invalidate";
    
    String JSON_MSG_CAM = "camList";
    
    /** 消息字段：资源列表 */
    String JSON_MSG_RESOURCELIST = "resourceList";
    
    /** 消息字段：功能是否更新 */
    String JSON_MSG_UPDATE_FUNC = "UpdateList";
    
    /** 消息字段：评论 */
    String JSON_COMMENT_LIST = "CommentList";
    
    /** 消息字段：点赞 */
    String JSON_PRAISE_LIST = "PraiseList";
    
    /** 置顶排序 */
    String SET_TOP_SORT = "1";
    
    String RECOMMENDID = "recommendId";
    
    String COMMENTID = "commentId";
    
    String PRAISEID = "praiseId";
    
    String PRAISECOUNT = "praiseCount";
    
    // 客户端类型
    String IOS = "IOS";
    
    String ANDROID = "Android";
    
    String PC = "PC";
    
    String VERSION_2 = "2.0";
    
    String WEB_YTPE = "1"; // 1:web
    
    String PC_YTPE = "2"; // 2:pc
    
    String ANDROID_YTPE = "3"; // 3:android
    
    String IOS_YTPE = "4"; // 4:ios
    
    String WP_YTPE = "5"; // 5:wp
    
    String CON_MSG_TYPE_TRANSPARENT_0 = "0"; // 透传消息
    
    String CON_MSG_TYPE_NOTIFY_1 = "1"; // alert notify 消息
    
    String LIVE_TYPE = "1";
    
    String DEMAND_TYPE = "2";
    
    String FILE_LIST = "ls -l ";
    
    String FILE_MODE_BITS = "chmod -R 777 ";
    
    String DEV_REG = "DEV_REG";
    
    /** 进出刷卡上报接口 */
    String ENTRY_EXIT_NOTIFY = "ENTRY_EXIT_NOTIFY";
    
    String SYNC_TEACHER = "SYNC_TEACHER";
    
    String SYNC_STUDENT = "SYNC_STUDENT";
    
    String SYNC_ADS = "SYNC_ADS";
    
    /** 打卡上报成功描述 */
    String RECV_SUCCESS_DES = "SUCCESS";
    
    /** 手机号不存在 */
    String PHONE_NOT_EXIST_DESC = "Phone To Bind Not Exists";
    
    /** 短信验证码错误 描述 */
    String SMS_VALI_CODE_ERROR_DESC = "SMS ValiCode Error";
    
    /** 短信验证码过期 描述 */
    String SMS_VALI_CODE_EXPIRED_DESC = "SMS ValiCode Expired";
    
    /** 用户停用 描述 */
    String USER_DISABLED_DES = "User Disabled";
    
    /** 用户套餐欠费 描述 */
    String USER_IN_DEFICIT_DES = "Package In Deficit";
    
    /** 用户名或密码错误 描述 */
    String USERNAME_OR_PWD_ERROR_DES = "Username Or Password Error";
    
    // 进出入类型：
    /** 入校 */
    String IN = "1";// :入园
    
    /** 离校 */
    String OUT = "2"; // :离园
    
    /** 未知 */
    String UN_KNOWN = "3"; // :离园
    
    /** 0：学生 默认 */
    String USER_TYPE_STUDENT = "0"; // 0：学生 默认
    
    /** 1：老师 教职工 */
    String USER_TYPE_USER_TEACHER = "1"; // 1：老师 教职工
    
    /** 1：拉取学生信息 */
    String taskValue_1_SyncStudent = "1";//
    
    /** 2：拉取老师信息 */
    String taskValue_2_SyncUser = "2";//
    
    /** 3：拉取广告信息 */
    String taskValue_3_SyncAds = "3";//
    
    /** 4：版本升级信息 */
    String taskValue_4_checkVersion = "4";//
    
    // 预留：以便后续对接多种型号设备的不同功能进行区分
    // 0：北京新长远
    // 1：广州广告机（自研）
    // 2：威海北洋（中小学）
    // 3：北京泰德（中小学）
    // 4：中控设备（设备网关）
    // 5: 内部设备
    
    /** 1：广州广告机（自研） */
    String device_Type_1_Independent_research_and_development = "1";
    
    /** 4：中控设备（设备网关） */
    String device_Type_2_deviceGw = "4";
    
    // 考勤 220-249
    // 接送记录
    String ID_CODE_RECEIVEID = "220";
    
    // 考勤机配置任务ID
    String ID_CODE_TASKID = "221";
    
    // 考勤机广告ID
    String ID_CODE_ADID = "222";
    
    // 班级圈 503
    String ID_CODE_CLASSCYCLE = "503";
    
    String CURRENT_USER = "loginUser";
    
    
 // 组织+用户相关
    // Root / 全零000 全球 国家 省市区 001
    // ..
    // 学校 010
    // 年级 011
    // 班级 012
    // 用户（家长，老师）050
    // 学生 051
    // …
    // 历史ID 默认 还是字母
    //
    // 资源相关
    // 100 开始 目前默认 101 102 103 999
    // 历史ID 默认 还是字母
    
    String SYS_ID = "320100201605041021325910521bukm8";
    
    /** 学校 （幼儿园） */
    String ID_CODE_NURID = "010";
    
    /** 用户 */
    String ID_CODE_USERID = "050";
    
    String ID_CODE_RESOURCEID = "100";
}
