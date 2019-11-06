package cn.test.constant;

/**
 * 区域后台API url
 *
 * @author lwf
 * @date 2019/8/30 16:46
 */
public interface PlatformAdminUrl {

    /**
     * 图片验证码URI
     */
    String IMG_CODE_URL = HostAddress.PLATFORM_ADMIN_HOST.getHost() + "/api/code/image";
    /**
     * 登陆URI
     */
    String LOGIN_URL = HostAddress.PLATFORM_ADMIN_HOST.getHost() + "/api/system/doLogin";

    /**
     * 获取用户信息URI
     */
    String USER_INFO_URL = HostAddress.PLATFORM_ADMIN_HOST.getHost() + "/api/system/user/get";

    /**
     * 订单列表
     */
    String ORDER_LIST_URL = HostAddress.PLATFORM_ADMIN_HOST.getHost() + "/order/orderList";


}
