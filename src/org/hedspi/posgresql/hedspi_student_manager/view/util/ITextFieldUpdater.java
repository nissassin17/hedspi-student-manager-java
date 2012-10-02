package org.hedspi.posgresql.hedspi_student_manager.view.util;

public interface ITextFieldUpdater<T extends Object> {
	void setText(T obj, String text);
	String getText(T obj);
}
