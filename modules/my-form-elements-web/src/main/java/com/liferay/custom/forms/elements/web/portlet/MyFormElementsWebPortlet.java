package com.liferay.custom.forms.elements.web.portlet;

import com.liferay.custom.forms.elements.web.constants.MyFormElementsWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author 91965
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Custom Framework Example",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/jquery.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/bootstrap-tab.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=My Custom Form Elements",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyFormElementsWebPortletKeys.MYFORMELEMENTSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyFormElementsWebPortlet extends MVCPortlet {
}