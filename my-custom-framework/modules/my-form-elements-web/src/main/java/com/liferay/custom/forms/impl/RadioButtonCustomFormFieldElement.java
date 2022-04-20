package com.liferay.custom.forms.impl;

import com.liferay.custom.forms.api.CustomFormElement;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {
		   
		    "custom.form.field.type.service.key=radio-button",
		    "custom.form.field.type.service.ranking=0",
		    "custom.form.field.type.icon=radio-button",
		    "custom.form.field.type.name=Radio Button",
		    "custom.form.field.type.description=This is a new radion button to choose yes or no"
		    
		  },
		  service = CustomFormElement.class
		)
public class RadioButtonCustomFormFieldElement extends BaseCustomFormElement {

	private String customFormElementName;
	private String customFormElementDescription;
	private String customFormElementIcon;

	@Activate
	private void activate(Map<String, ?> properties) {
		
		this.customFormElementName  = properties.get("custom.form.field.type.name").toString();
		this.customFormElementDescription  = properties.get("custom.form.field.type.description").toString();
		this.customFormElementIcon = properties.get("custom.form.field.type.icon").toString();
	}
	
	@Override
	public String renderFormElement() {
		
		return "<div class=\"form-check\">\r\n" + 
				"	<input\r\n" + 
				"		class=\"form-check-input\"\r\n" + 
				"		type=\"radio\"\r\n" + 
				"		name=\"exampleRadios\"\r\n" + 
				"		id=\"exampleRadios1\"\r\n" + 
				"		value=\"Yes\"\r\n" + 
				"		checked\r\n" + 
				"	/>\r\n" + 
				"	<label class=\"form-check-label\" for=\"exampleRadios1\">Yes</label>\r\n" + 
				"</div>\r\n" + 
				"<div class=\"form-check\">\r\n" + 
				"	<input\r\n" + 
				"		class=\"form-check-input\"\r\n" + 
				"		type=\"radio\"\r\n" + 
				"		name=\"exampleRadios\"\r\n" + 
				"		id=\"exampleRadios2\"\r\n" + 
				"		value=\"No\"\r\n" + 
				"	/>\r\n" + 
				"	<label class=\"form-check-label\" for=\"exampleRadios2\">\r\n" + 
				"		No\r\n" + 
				"	</label>\r\n" + 
				"</div>";
	}


	@Override
	public String getCustomFormElementName() {
		return this.customFormElementName;
	}

	@Override
	public String getCustomFormElementDescription() {
		return this.customFormElementDescription;
	}
	
	@Override
	public String getIcon() {
		String iconName = super.getIcon();
		
		if(Validator.isNotNull(this.customFormElementIcon) || !this.customFormElementIcon.isEmpty())
		{
			iconName = this.customFormElementIcon;
		}	
		return iconName; 
	}
	
	
	
}
