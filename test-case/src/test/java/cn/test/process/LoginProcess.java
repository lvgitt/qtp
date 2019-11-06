package cn.test.process;

import cn.test.TestCaseApp;
import cn.test.dto.Result;
import cn.test.testcase.CommonCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lwf
 * @date 2019/8/30 16:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestCaseApp.class})
public class LoginProcess {
    @Autowired
    private CommonCase commonCase;

    @Test
    public void getToken() {
//        登陆获取token
        String token = commonCase.loginPlatformAdmin("TS_0000001", "admin", "admin");
//        拿token获取用户信息
        Result userInfo = commonCase.getUserInfo();

        System.out.println(userInfo);
    }
}
