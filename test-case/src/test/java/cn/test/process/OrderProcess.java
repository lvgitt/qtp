package cn.test.process;

import cn.test.TestCaseApp;
import cn.test.dto.Result;
import cn.test.testcase.CommonCase;
import cn.test.testcase.OrderCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * 订单流程测试
 *
 * @author lwf
 * @date 2019/8/30 18:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestCaseApp.class})
public class OrderProcess {

    @Autowired
    private OrderCase orderCase;
    @Autowired
    private CommonCase commonCase;

    @Test
    public void orderList() {
        HashMap<String, Object> param = new HashMap<>();

        param.put("status", 2);
        param.put("tradeNo", "115123144482");
        param.put("storeName", "方家铺子旗舰店");
        param.put("startDate", "2014-12-31 13:52:26");
        param.put("endDate", "2019-12-31 13:52:26");
        param.put("pageIndex", 1);
        param.put("pageSize", 10);

        Result result = orderCase.orderList(param);

        System.out.println(result);

    }
}
