package com.liferay.custom.forms.impl;

import com.liferay.custom.forms.api.CustomFormElement;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {
		   
		    "custom.form.field.type.service.key=input-text",
		    "custom.form.field.type.service.ranking=0",
		    "custom.form.field.type.icon=code",
		    "custom.form.field.type.name=Input Text",
		    "custom.form.field.type.description=This is a input text field in my custom form app. Use it wisely."
		    
		  },
		  service = CustomFormElement.class
		)
public class TextBoxCustomFormFieldElement extends BaseCustomFormElement {

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
		
		return "<input type='text' />";
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
	
	@Override
	public boolean isOutOfTheBox() {
		return Boolean.TRUE;
	}
	
	
	
}
