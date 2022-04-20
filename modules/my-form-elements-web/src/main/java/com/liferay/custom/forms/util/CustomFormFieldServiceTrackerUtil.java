package com.liferay.custom.forms.util;

import com.liferay.custom.forms.api.CustomFormElement;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CustomFormFieldServiceTrackerUtil extends ServiceTracker<CustomFormElement, CustomFormElement> {

	
	public CustomFormFieldServiceTrackerUtil(BundleContext context, Class<CustomFormElement> clazz,
			ServiceTrackerCustomizer<CustomFormElement, CustomFormElement> customizer) {
		super(context, clazz, customizer);
	}

	public static SortedMap<String, CustomFormElement> getRegisteredCustomFieldMap() {

		SortedMap<String, CustomFormElement> registeredServiceList = new TreeMap<String, CustomFormElement>();
		LinkedHashMap<String,Integer> serviceRankingMap = new LinkedHashMap<>();
		Bundle bundle = FrameworkUtil.getBundle(CustomFormFieldServiceTrackerUtil.class);
		CustomFormFieldServiceTrackerUtil _customFormFieldServiceTracker = new CustomFormFieldServiceTrackerUtil(
				bundle.getBundleContext(), CustomFormElement.class, null);
		_customFormFieldServiceTracker.open();
		SortedMap<ServiceReference<CustomFormElement>, CustomFormElement> _trackedServiceList = _customFormFieldServiceTracker
				.getTracked();
		_trackedServiceList.forEach((_serviceReference, _customFormElement) -> {
			String customFormElementKey = _serviceReference.getProperty("custom.form.field.type.service.key").toString();
			int serviceRanking = Integer.parseInt(_serviceReference.getProperty("custom.form.field.type.service.ranking").toString());
			
			
			
			if(serviceRanking == 0)
			{
				registeredServiceList.put(customFormElementKey,_customFormElement);
				serviceRankingMap.put(customFormElementKey,serviceRanking);
			}
			else if(serviceRanking > serviceRankingMap.get(customFormElementKey))
			{
				registeredServiceList.put(customFormElementKey,_customFormElement);
				serviceRankingMap.put(customFormElementKey,serviceRanking);
								
			}
			
		});

		_customFormFieldServiceTracker.close();
		return registeredServiceList;

	}

	
	
}
