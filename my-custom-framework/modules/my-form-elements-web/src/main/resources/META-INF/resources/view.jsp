<%@ include file="init.jsp" %>
<%@ page import="com.liferay.custom.forms.util.CustomFormFieldServiceTrackerUtil"%>
<%@page import="java.util.*"%>
<%@ page import="com.liferay.custom.forms.api.CustomFormElement"%>

	
	<%
	SortedMap<String,CustomFormElement> registeredCustomFieldMap = CustomFormFieldServiceTrackerUtil.getRegisteredCustomFieldMap();
	
	
	%>
<div class="container">
	<div class="row">
		<div class="col-lg-2">
		<legend>Form field types</legend>
		
			<ol id="elementList">
		<% for(String elementKey:registeredCustomFieldMap.keySet())
				{ 
			
		%>
		
			<li>
			<clay:icon symbol="<%= registeredCustomFieldMap.get(elementKey).getIcon()%>"/>
			<font><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementName()%></font>
			
			</li>
		
		<% } %>
			</ol>
		</div>
		<div class="col-lg-10">

<div class="sheet-example">
	<ul class="nav nav-underline custom-tab" role="tablist">
	<% for(String elementKey:registeredCustomFieldMap.keySet())

		{ 
		if(elementKey.equalsIgnoreCase(registeredCustomFieldMap.firstKey())){
		%>
		
				<li class="nav-item">
			<a
				aria-controls="navUnderlineFields"
				aria-selected="true"
				class="active nav-link"
				data-toggle="tab"
				href="#<%= elementKey%>"
				id="<%= elementKey%>Tab"
				role="tab"
				><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementName()%></a
			>
		</li>
		<% } else { %>
			<li class="nav-item">
			<a
				aria-controls="navUnderlineFields"
				aria-selected="true"
				class="nav-link"
				data-toggle="tab"
				href="#<%= elementKey%>"
				id="<%= elementKey%>Tab"
				role="tab"
				><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementName()%></a
			>
		</li>
		<% 
			}
				} %>
	
		
	</ul>
	<div class="tab-content custom-tab-content">
		
		<% for(String elementKey:registeredCustomFieldMap.keySet())
		{	CustomFormElement _customFormElement = registeredCustomFieldMap.get(elementKey);
			if(elementKey.equalsIgnoreCase(registeredCustomFieldMap.firstKey())){
		%>
		
		<div
			aria-labelledby="<%= elementKey%>Tab"
			class="active fade show tab-pane"
			id="<%= elementKey%>"
			role="tabpanel"
		>
			<clay:container style="padding-top: 15px;">
			<legend>Custom Form Field Details:
			<% if(_customFormElement.isOutOfTheBox()){ %>
			<span class="badge badge-primary badge-pill">
			<span class="badge-item badge-item-expand">Out of the box feature</span>
			</span>
			<% } else {%>
			
			<span class="badge badge-warning badge-pill">
			<span class="badge-item badge-item-expand">Extended / Customized feature</span>
			</span>
			
			<% } %>
			</legend>
			<clay:content-section>
			<clay:content-col>
			<clay:content-row><clay:label-item-before> Form Field Name:</clay:label-item-before></clay:content-row>
			<clay:content-row>
			<div class="card">
				<div class="card-body"><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementName()%></div>
			</div>			
			</clay:content-row>
			</clay:content-col>
			</clay:content-section>
			
			<clay:content-section>
			<clay:content-col>
			<clay:content-row><clay:label-item-before> Description:</clay:label-item-before></clay:content-row>
			<clay:content-row>
			<div class="card">
				<div class="card-body"><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementDescription()%></div>
			</div>			
			</clay:content-row>			</clay:content-col>
			</clay:content-section>

			<clay:content-section>
			<clay:content-col>
			<clay:content-row><clay:label-item-before> Render element:</clay:label-item-before></clay:content-row>
			<clay:content-row>
			<div class="card col-lg-8">
				<div class="card-body"><%= registeredCustomFieldMap.get(elementKey).renderFormElement() %></div>
			</div>			
			</clay:content-row>			</clay:content-col>
			</clay:content-section>
			

		</clay:container>
		
		
		
		</div>
		<% } else { %>
		<div
			aria-labelledby="<%= elementKey%>Tab"
			class="fade tab-pane"
			id="<%= elementKey%>"
			role="tabpanel"
		>
			<clay:container style="padding-top: 15px;">
			<legend>Custom Form Field Details:
			<% if(_customFormElement.isOutOfTheBox()){ %>
			<span class="badge badge-primary badge-pill">
			<span class="badge-item badge-item-expand">Out of the box feature</span>
			</span>
			<% } else {%>
			
			<span class="badge badge-warning badge-pill">
			<span class="badge-item badge-item-expand">Extended / Customized feature</span>
			</span>
			
			<% } %>
			</legend>			
			<clay:content-section>
			<clay:content-col>
			<clay:content-row><clay:label-item-before> Form Field Name:</clay:label-item-before></clay:content-row>
			<clay:content-row>
			<div class="card">
				<div class="card-body"><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementName()%></div>
			</div>			
			</clay:content-row>
			</clay:content-col>
			</clay:content-section>
			
			<clay:content-section>
			<clay:content-col>
			<clay:content-row><clay:label-item-before> Description:</clay:label-item-before></clay:content-row>
			<clay:content-row>
			<div class="card">
				<div class="card-body"><%= registeredCustomFieldMap.get(elementKey).getCustomFormElementDescription()%></div>
			</div>			
			</clay:content-row>			</clay:content-col>
			</clay:content-section>

			<clay:content-section>
			<clay:content-col>
			<clay:content-row><clay:label-item-before> Render element:</clay:label-item-before></clay:content-row>
			<clay:content-row>
			<div class="card col-lg-8">
			<div class="card-body"><%= registeredCustomFieldMap.get(elementKey).renderFormElement() %></div>
			</div>			
			</clay:content-row>			</clay:content-col>
			</clay:content-section>
			

		</clay:container>
		</div>
		
		<% 
			}
				} %>
	
	</div>
</div>
			
		
		</div>
		
		
	</div>
</div>
	
	
	
