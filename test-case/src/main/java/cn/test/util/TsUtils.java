package cn.test.util;

import cn.hutool.core.collection.CollUtil;
import cn.test.testcase.CommonCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;

/**
 * 通用工具类
 *
 * @author lwf
 * @date 2019/3/2212:35
 */
@Component
public class TsUtils<T> {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getToken() {
        String token = redisTemplate.opsForValue().get("token");
        if (token == null) {
            CommonCase commonCase = new CommonCase();
//            commonCase.loginPlatformAdmin()
        }
        return token;
    }


    /**
     * 检验必填参数是否有值（有值返回的Result为null，否则直接返回“参数***不能为空！”）
     *
     * @return String 返回的错误信息
     * @author lwf
     * @date 2019/3/25 14:26
     * @params [params：请求参数, requiredParams:必填参数集合，如果所有参数都要校验则传空]
     */
    public String checkRequiredParameters(Map<String, Object> params, String... requiredParams) {
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        boolean empty = isEmpty(requiredParams);
        List<String> paramList = new ArrayList<>();
        if (!empty) {
            paramList = CollUtil.newArrayList(requiredParams);
        }
        for (String param : paramList) {
            if (!params.containsKey(param)) {
                return "参数" + param + "不能为空!";
            }
        }
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!empty && paramList.contains(key)) {
                if (isEmpty(value)) {
                    return "参数" + key + "不能为空!";
                }
                // 如果有传requiredParams，则不必进行下面的校验
                continue;
            }
            // 如果没传requiredParams ，说明所有参数都需要校验
            if (empty && isEmpty(value)) {
                return "参数" + key + "不能为空!";
            }
        }
        return null;
    }

    /**
     * 校验任意对象是否为空
     * （集合为null或size==0）
     * (字符串为null或字符串为“null”或字符串去除空格为“”)
     *
     * @return boolean
     * @author lwf
     * @date 2019/3/25 14:53
     * @params [obj]
     */
    public boolean isEmpty(Object obj) {

        String nullStr = "null";
        String undefineStr = "undefined";
        if (obj == null) {
            return true;
        }
        if (obj instanceof List) {
            return ((List<?>) obj).isEmpty() || ((List<?>) obj).get(0) == null;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            return objArr.length <= 0;
        }
        if (obj instanceof String) {
            return "".equals(obj.toString().trim()) || nullStr.equalsIgnoreCase(obj.toString().trim()) || undefineStr.equalsIgnoreCase(obj.toString().trim());
        }

        return false;

    }

    /**
     * 校验任意对象是否为非空--避免调用isEmpty方法漏加！
     * （集合为null或size==0）
     * (字符串为null或字符串为“null”或字符串去除空格为“”)
     *
     * @param obj
     * @return boolean
     * <p>@author lwf
     * <p>@date 2019/7/22 15:23
     */
    public boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

}
