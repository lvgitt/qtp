package cn.test.dto;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;

/**
 * 统一定义所有返回结果
 *
 * @author lwf
 * @date 2019/4/8 15:15
 */
@Data
@ToString
public class Result implements Serializable {
    /**
     * 成功的消息代码
     */
    public static final int CODE_SUCCESS = 101;
    /**
     * 失败的消息代码
     */
    public static final int CODE_FAILURE = 102;
    /**
     * 异常的消息代码
     */
    public static final int CODE_EXCEPTION = 103;
    /**
     * 找不到相关数据代码
     */
    public static final int CODE_DATA_NOT_FOUND = 104;
    /**
     * 请求被拒绝代码
     */
    public static final int CODE_REFUSE = 105;
    /**
     * 数据重复代码
     */
    public static final int CODE_DUPLICATE_DATA = 106;
    /**
     * 写入日志异常
     */
    public static final int CODE_WRITE_LOG_FAIL = 107;
    /**
     * 转换消息失败
     */
    public static final int CODE_VERB_MSG_FAIL = 108;
    /**
     * 请求超时
     */
    public static final int CODE_TIME_OUT = 109;
    /**
     * 异地登陆
     */
    public static final int CODE_OFFSITE_LANDING = 110;
    /**
     * token 超时
     */
    public static final int CODE_TOKEN_TIME_OUT = 111;
    /**
     * 系统异常提示语
     */
    public static final String INFO_EXCEPTION = "系统异常: 请联系管理员！";
    /**
     * 操作成功提示语
     */
    public static final String INFO_SUCCESS = "成功";
    public static final String INFO_SUCCESS_EDIT = "修改成功";
    private static final long serialVersionUID = 123456789222L;
    private final static Object EMPTY_OBJECT = Collections.emptyMap();
    /**
     * 报错信息
     */
    private String error;
    /**
     * 报错路径
     */
    private String path;
    /**
     * 异常详情
     */
    private String errorDetail;
    /**
     * 错误编码
     */
    private int httpCode;
    /**
     * 报错时间
     * 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
     */
    private String timestamp = DateUtil.now();
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
        code = CODE_SUCCESS;

    }

    public Result(Integer code, String msg, Object data) {

        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result getSuccessResult(Object data) {
        return new Result(CODE_SUCCESS, "", data);
    }

    /**
     * 接口请求返回信息
     *
     * @param code 返回代码
     * @param msg  描述
     * @param data 返回对象
     * @return Result
     */
    public static Result message(int code, String msg, Object data) {
        Result Result = new Result();
        Result.setCode(code);
        Result.setMsg(msg);
        Result.setData(data);
        return Result;
    }

    /**
     * 接口请求返回信息
     *
     * @param code 返回代码
     * @param msg  描述
     * @return Result
     */
    public static Result message(int code, String msg) {
        return message(code, msg, EMPTY_OBJECT);
    }

    /**
     * 成功的消息
     *
     * @param msg 消息
     * @return 消息
     */
    public static Result success(String msg) {
        return message(CODE_SUCCESS, msg);
    }

    /**
     * 成功的消息
     *
     * @param msg  消息
     * @param data 消息携带的数据
     * @return 消息
     */
    public static Result success(String msg, Object data) {
        return message(CODE_SUCCESS, msg, data);
    }

    /**
     * 成功的消息
     *
     * @param data 消息携带的数据
     * @return 消息
     */
    public static Result success(Object data) {
        return message(CODE_SUCCESS, "", data);
    }

    /**
     * 成功的消息
     *
     * @return 消息
     */
    public static Result success() {
        return message(CODE_SUCCESS, "", EMPTY_OBJECT);
    }

    /**
     * 失败的消息
     *
     * @param msg 消息
     * @return 消息
     */
    public static Result failure(String msg) {
        return message(CODE_FAILURE, msg);
    }

    /**
     * 异常的消息
     *
     * @param msg 消息
     * @return 消息
     */
    public static Result exception(String msg) {
        return message(CODE_EXCEPTION, msg, EMPTY_OBJECT);
    }

    /**
     * 异常的消息
     *
     * @return 消息
     */
    public static Result exception() {
        return message(CODE_EXCEPTION, INFO_EXCEPTION);
    }

}
