<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="form-group col-md-12">
     <label class="col-md-2 col-sm-2 control-label">Shift:</label>
     <div class="col-md-4 col-sm-4">
         <div class='input-group'>
         	  <form:input path="${field_name_from}" class="form-control" id="${field_name_from}" />
              <span class="input-group-addon">
                  <span class="glyphicon glyphicon-time"></span>
              </span>
          </div>
          <form:errors path="${field_name_from}" class="control-error" />
     </div>
     <div class="control-label col-md-1 col-sm-1 text-center">
     to
     </div>
     <div class="col-md-4 col-sm-4">
         <div class='input-group'>
              <form:input path="${field_name_to}" class="form-control" id="${field_name_to}" />
              <span class="input-group-addon">
                  <span class="glyphicon glyphicon-time"></span>
              </span>
          </div>
          <form:errors path="${field_name_to}" class="control-error" />
     </div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$('#${field_name_from}, #${field_name_to}').timepicki();
});						            
</script>