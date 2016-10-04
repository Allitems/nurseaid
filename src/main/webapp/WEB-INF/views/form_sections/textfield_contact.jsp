<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:bind path="${field_name}">
  <div class="form-group col-md-12">					  
  		<label class="col-md-3 col-sm-3 control-label">${field_label} :</label>
        <div class="col-md-7 col-sm-7">
        	<form:input path="${field_name}" class="form-control" id="${field_name}" placeholder="${field_placeholder}" />
			<form:errors path="${field_name}" class="control-error" />
        </div>
  </div>
</spring:bind>