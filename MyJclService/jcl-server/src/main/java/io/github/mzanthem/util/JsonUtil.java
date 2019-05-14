package io.github.mzanthem.util;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Description: 整合第三方框架支持
 * @author 何波
 * @date 2015年3月11日 上午10:05:24
 * 
 */
public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 把json字符串转换为对象
	 * 
	 * @param json
	 * @param parametrized
	 * @param parameterClasses
	 * @return 如果为空串，将返回null
	 * @throws ClientException
	 * @since
	 */
	public static <T> T parseJson(String json, Class<?> parametrized,
			Class<?>... parameterClasses) {
		if (json == null || json=="" ) {
			return null;
		}
		try {
			JavaType jt = mapper.getTypeFactory().constructParametricType(
					parametrized, parameterClasses);
			return mapper.readValue(json, jt);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T parseJson(String json, Class<?> parametrized) {
		if (json == null || json=="" ) {
			return null;
		}
		try {
			return (T) mapper.readValue(json, parametrized);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String toJson(Object obj) {
		if (obj == null) {
			return "";
		}
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
