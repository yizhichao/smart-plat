package com.allcam.utils.exception;

/**
 * 错误码定义。
 *
 * @author marui
 */
public interface ErrorCode
{
    /**
     * 未知错误
     */
    String COMMON_UNKNOWN_ERROR = "common.unknown.error";

    /**
     * 功能未实现错误
     */
    String COMMON_UNIMPLEMENTED_FUNCTION = "common.unimplemented.error";

    /**
     * 获取sequence唯一键失败
     */
    String COMMON_GET_SEQUENCE_UNIKEY_FAIL = "common.get.sequence.key.fail";

    /**
     * 加载密钥文件失败
     */
    String COMMON_LOAD_KEYSTORE_FAIL = "common.load.keystore.fail";

    /**
     * 打开http连接失败
     */
    String COMMON_OPEN_HTTP_CONNECTION_FAIL = "common.open.http.connection.fail";

    /**
     * 发送http请求失败
     */
    String COMMON_SEND_HTTP_REQUEST_FAIL = "common.send.http.request.fail";

    /**
     * 解析xml失败
     */
    String COMMON_PARSE_XML_FAIL = "common.parse.xml.fail";

    /**
     * 流操作失败
     */
    String COMMON_OPERATE_STREAM_FAIL = "common.operate.stream.fail";

    /**
     * 数据库操作异常
     */
    String SYSTEM_DB_UNIQUE_KEY_CONFLICTION = "20199";
}
