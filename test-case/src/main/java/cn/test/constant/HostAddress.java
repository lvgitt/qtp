package cn.test.constant;


/**
 * @author lwf
 * @date 2019/8/30 16:54
 */
public enum HostAddress {

    PLATFORM_ADMIN_HOST {
        @Override
        public String getHost() {
            return "http://x.x.x.x:8081";
        }
    },
    ADMIN_HOST {
        @Override
        public String getHost() {
            return "http://x.x.x.x:8080";
        }
    },
    GATEWAY_HOST {
        @Override
        public String getHost() {
            return "http://x.x.x.x:8088";
        }
    };

    /**
     * 获取host地址
     *
     * @return java.lang.String
     * <p>@author lwf
     * <p>@date 2019/8/30 16:59
     */
    public abstract String getHost();
}
