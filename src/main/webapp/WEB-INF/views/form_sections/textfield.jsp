<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:choose>
	<c:when test="${empty is_front_end}">
		<c:set var="label_class" value="col-md-2 col-sm-3" scope="request"/>
		<c:set var="field_class" value="col-md-6 col-sm-6" scope="request"/>
	</c:when>
	<c:otherwise>
		<c:set var="label_class" value="col-md-3 col-sm-3" scope="request"/>
		<c:set var="field_class" value="col-md-4 col-sm-4" scope="request"/>
	</c:otherwise>
</c:choose>

<spring:bind path="${field_name}">
  <div class="form-group col-md-12">					  
  		<label class="${label_class} control-label">${field_label} :</label>
        <div class="${field_class}">
        	<form:input path="${field_name}" class="form-control" id="${field_name}" placeholder="${field_placeholder}" />
			<form:errors path="${field_name}" class="control-error" />
        </div>
  </div>
</spring:bind>