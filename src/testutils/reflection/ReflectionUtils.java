package testutils.reflection;

import java.lang.reflect.Field;

public class ReflectionUtils {

	/**
	 * Get a field from an object
	 * @param obj
	 * @param fieldName
	 * @param expectedType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getField(Object obj, String fieldName, Class<T> expectedType) {
		
		try {
		
			Field field = obj.getClass().getDeclaredField(fieldName);
			
			field.setAccessible(true);
			
			System.out.println("type:" + field.getType());
			
			return (T) field.get(obj);
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
