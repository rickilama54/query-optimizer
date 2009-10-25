package queryopt.components;

import java.util.List;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.services.PropertyAccess;

public class GenericValueEncoder<T> implements ValueEncoder<T> {

	private List<T> list;
	private final PropertyAccess access;
	private final String fieldName;

	public GenericValueEncoder(List<T> list, String fieldName, PropertyAccess propertyAccess) {
		this.list = list;
		this.fieldName = fieldName;
		this.access = propertyAccess;
	}

	public String toClient(T obj) {
		if (fieldName == null) {
			return obj + "";
		} else {
			String label = "";
			String[] propertyNames = fieldName.split(" ");
			for (String propName : propertyNames) {
				Object property = obj;
				// Not a property but a string
				if (propName.startsWith("'") && propName.endsWith("'"))
					property = propName.subSequence(1, propName.length() - 1);
				else {
					// Property. so find it's value
					String[] properies = propName.split("\\.");
					for (String propertyName : properies) {
						property = access.get(property, propertyName);
					}
				}
				label += property;
			}
			return label + "";
		}
	}

	public T toValue(String string) {
		for (T obj : list) {
			if (fieldName == null) {
				if ((obj + "").equals(string)) {
					return obj;
				}
			} else {
				// Construct the select object value from
				// properties in the fieldName delimited by a blank character
				String label = "";
				String[] propertyNames = fieldName.split(" ");
				for (String propName : propertyNames) {
					Object property = obj;
					// Not a property but a string
					if (propName.startsWith("'") && propName.endsWith("'"))
						property = propName.subSequence(1, propName.length() - 1);
					else {
						// Property. so find it's value
						String[] properies = propName.split("\\.");
						for (String propertyName : properies)
							property = access.get(property, propertyName);
					}
					label += property;
				}
				if (label.equals(string)) {
					return obj;
				}
			}
		}
		return null;
	}
}
