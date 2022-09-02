package cn.test.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * 自定义复杂类型处理器<br/>
 * 用于处理数据库中json类型字段和实体类中字段的映射关系
 * <p> @author lwf </p>
 * <p> @date 2022-06-18 20:06:03 </p>
 */
public class JsonTypeHandler extends FastjsonTypeHandler {
    public JsonTypeHandler(Class<Object> type) {
        super(type);
    }

    @Override
    protected Object parse(String json) {
        try {
            if (json.startsWith("[")) {
                if (json.contains("{")) {
                    return new ObjectMapper().readValue(json, new TypeReference<List<Map<String, Object>>>() {
                    });
                }
                return new ObjectMapper().readValue(json, new TypeReference<List<Object>>() {
                });
            } else if (json.startsWith("{")) {
                return new ObjectMapper().readValue(json, Map.class);
            }
            return json;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
