package com.liferay.custom.forms.api;

public interface CustomFormElement {

	
	//  Renders the actual form field type
	public String renderFormElement();

	// Icon to represent the form field type
	public String getIcon();
	
	// Just a custom flag to display a badge in the UI
	public default boolean isOutOfTheBox() {
		return Boolean.FALSE;
	}

	//Name of the custom form field type
	public String getCustomFormElementName();

	//Description of the custom form field type
	public String getCustomFormElementDescription();
	
	//Inject a javascript functionality
	public String loadJavascriptConfiguration();
	
}
