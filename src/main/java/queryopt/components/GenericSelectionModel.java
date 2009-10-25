package queryopt.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.util.AbstractSelectModel;

public class GenericSelectionModel<T> extends AbstractSelectModel {

	private String labelField;

	private List<T> list;

	private final PropertyAccess adapter;

	public GenericSelectionModel(List<T> list, String labelField, PropertyAccess adapter) {
		this.labelField = labelField;
		this.list = list;
		this.adapter = adapter;
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		List<OptionModel> optionModelList = new ArrayList<OptionModel>();
		for (T obj : list) {
			if (labelField == null) {
				optionModelList.add(new OptionModelImpl(obj + "", obj));
			} else {
				String label = "";
				String[] propertyNames = labelField.split(" ");
				for (String propName : propertyNames) {
					Object property = obj;
					// Not a property but a string
					if (propName.startsWith("'") && propName.endsWith("'"))
						property = propName.subSequence(1, propName.length() - 1);
					else {
						// Property. so find it's value
						String[] properies = propName.split("\\.");
						for (String propertyName : properies)
							property = adapter.get(property, propertyName);
					}
					label += property;
				}
				optionModelList.add(new OptionModelImpl(label + "", obj));
			}
		}
		return optionModelList;
	}
}
