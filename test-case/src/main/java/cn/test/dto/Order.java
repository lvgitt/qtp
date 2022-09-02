package cn.test.dto;


import lombok.Data;

import java.util.List;

/**
 *
 * @author lwf
 * @since 2022-08-18 18:45:27
 */
@Data
//@TableName(autoResultMap = true,value = "order")
public class Order  {
    /**
     * ID主键
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 关联ID列表 JSON类型：[111,222,333]
     */
//    @TableField(typeHandler = JsonTypeHandler.class)
    private List<Number> boxIdList;
}

