package queryopt.model;

public class GenericHolder {
	private Long _key;
	private boolean _new;
	private boolean _deleted;

	public GenericHolder(boolean isNew, Long key) {
		_new = isNew;
		_key = key;
	}

	public Long getKey() {
		return _key;
	}

	public boolean isNew() {
		return _new;
	}

	public boolean setDeleted(boolean deleted) {
		return _deleted = deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}
}
