package cn.test.testcase;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.test.constant.PlatformAdminUrl;
import cn.test.dto.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lwf
 * @date 2019/8/30 16:36
 */
@Component
public class CommonCase {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 区域后台登陆方法
     *
     * @param platformCode 平台号
     * @param username     用户名
     * @param password     密码
     * @return cn.monecity.dto.Result
     * <p>@author lwf
     * <p>@date 2019/8/30 16:42
     */
    public String loginPlatformAdmin(String platformCode, String username, String password) {
        // 登陆
        String code = HttpUtil.get(PlatformAdminUrl.IMG_CODE_URL);
        // 登陆
        String loginData = HttpRequest.post(PlatformAdminUrl.LOGIN_URL)
                .header("Authorization", "Basic xxxxxx")
                .body("username=" + platformCode + ":" + username + "&password=" + password + "&imageCode=xxxx")
//                .body(JSON.toJSONString(param))
                .execute().body();

        Map map = JSON.parseObject(loginData, Map.class);
        Map data = (Map) map.get("data");
        Object jwtToken = data.get("value");
        String token = "Bearer " + jwtToken;

        redisTemplate.opsForValue().set("token", token);
        return token;
    }

    public Result getUserInfo() {
        String token = redisTemplate.opsForValue().get("token");
        String resData = HttpRequest.post(PlatformAdminUrl.USER_INFO_URL)
                .header("Authorization", token)
                .execute().body();

        return JSON.parseObject(resData, Result.class);
    }
}
