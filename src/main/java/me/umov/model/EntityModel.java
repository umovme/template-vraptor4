package me.umov.model;

import java.io.Serializable;

public interface EntityModel<T> extends Serializable {

	public T getId();

	public void setId(T id);

}
