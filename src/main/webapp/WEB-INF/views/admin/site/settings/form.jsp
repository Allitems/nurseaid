<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/admin/site/settings/edit/${ObjForm.getId()}" var="actionURL" />

<jsp:include page="../../../panels/message.jsp"></jsp:include>

<div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">
             	<div class="panel-body">
				
				<form:form method="post" enctype="multipart/form-data" modelAttribute="ObjForm" action="${actionURL}">
				
					<form:hidden path="id" />
					
					<c:set var="field_name" value="title" scope="request"/>
					<c:set var="field_label" value="Key" scope="request"/>
					<c:set var="field_placeholder" value="Title" scope="request"/>
					<c:set var="field_value" value="${ObjForm.getTitle()}" scope="request"/>
					<jsp:include page="../../../form_sections/label.jsp"></jsp:include>
					
					
					
					<c:choose>
						<c:when test="${ObjForm.getType() eq 'file'}">
							<c:set var="field_name" value="file" scope="request"/>
							<c:set var="field_label" value="File" scope="request"/>
							<c:set var="field_placeholder" value="File" scope="request"/>
							<jsp:include page="../../../form_sections/filefield.jsp"></jsp:include>
						</c:when>
						<c:otherwise>
							<c:set var="field_name" value="value" scope="request"/>
							<c:set var="field_label" value="Value" scope="request"/>
							<c:set var="field_placeholder" value="Value" scope="request"/>							
							<jsp:include page="../../../form_sections/textfield.jsp"></jsp:include>
						</c:otherwise>
					</c:choose>

					
					
					
					<jsp:include page="../../../form_sections/button.jsp"></jsp:include>
				
				</form:form>
				
				</div>

             </div>

         </div>

     </div>

 </div>