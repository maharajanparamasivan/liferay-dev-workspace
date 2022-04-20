package com.liferay.custom.forms.impl;

import com.liferay.custom.forms.api.CustomFormElement;

public abstract class BaseCustomFormElement implements CustomFormElement {
	
	@Override
	public String loadJavascriptConfiguration() {
		return "print-console-log";
	}

	@Override
	public String getIcon() {
		return "container";
	}

}
