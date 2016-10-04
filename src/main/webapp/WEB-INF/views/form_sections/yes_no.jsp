<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:bind path="${field_name}">
  <div class="form-group col-md-12">					  
  		<label class="col-md-2 col-sm-3 control-label">${field_label} :</label>
        <div class="col-md-6 col-sm-6">
        	<form:checkbox path="${field_name}" class="form-control yes_no" />
        	<!--<c:choose>
          		<c:when test="${item.getForType() eq 1}">
          			<form:checkbox path="${field_name}" class="form-control yes_no" />
          			<input  value="1" id="${field_name}" type="checkbox"  checked="">
          		</c:when>
          		<c:otherwise>
          			<input path="${field_name}" value="1" id="${field_name}" type="checkbox" class="form-control yes_no">
          		</c:otherwise>
          	</c:choose>        	-->
			<form:errors path="${field_name}" class="control-error" />
        </div>
  </div>
</spring:bind>