package cn.test.testcase;

import cn.hutool.http.HttpRequest;
import cn.test.constant.PlatformAdminUrl;
import cn.test.dto.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lwf
 * @date 2019/8/30 18:42
 */
@Component
public class OrderCase {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 区域平台订单列表
     *
     * @param
     * @return cn.monecity.dto.Result
     * <p>@author lwf
     * <p>@date 2019/8/30 18:46
     */
    public Result orderList(Map<String, Object> map) {
        String token = redisTemplate.opsForValue().get("token");
        String resData = HttpRequest.post(PlatformAdminUrl.ORDER_LIST_URL)
                .header("Authorization", token)
                .body(JSON.toJSONString(map))
                .execute().body();
        return JSON.parseObject(resData, Result.class);
    }

}
