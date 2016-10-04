<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:choose>
    <c:when test="${btn_text eq 'Add'}">
    	<spring:url value="/admin/site/user/add" var="actionURL" />
    </c:when>
    <c:otherwise>
    	<spring:url value="/admin/site/user/edit/${ObjForm.getId()}" var="actionURL" />
    </c:otherwise>
</c:choose>

<jsp:include page="../../../panels/message.jsp"></jsp:include>

<div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">
             	<div class="panel-body">
				
				<form:form method="post" modelAttribute="ObjForm" action="${actionURL}">
				
					<form:hidden path="id" />
					
					<c:set var="field_name" value="fullName" scope="request"/>
					<c:set var="field_label" value="Full Name" scope="request"/>
					<c:set var="field_placeholder" value="Full Name" scope="request"/>
					<jsp:include page="../../../form_sections/textfield.jsp"></jsp:include>
					
					<c:set var="field_name" value="email" scope="request"/>
					<c:set var="field_label" value="Email" scope="request"/>
					<c:set var="field_placeholder" value="Email" scope="request"/>
					<jsp:include page="../../../form_sections/textfield.jsp"></jsp:include>
					
					<c:set var="field_name" value="username" scope="request"/>
					<c:set var="field_label" value="Username" scope="request"/>
					<c:set var="field_placeholder" value="Username" scope="request"/>
					<jsp:include page="../../../form_sections/textfield.jsp"></jsp:include>
					
					<c:if test="${btn_text eq 'Add'}">					
						<c:set var="field_name" value="password" scope="request"/>
						<c:set var="field_label" value="Password" scope="request"/>
						<c:set var="field_placeholder" value="Password" scope="request"/>
						<jsp:include page="../../../form_sections/password.jsp"></jsp:include>
						
						
						<c:set var="field_name" value="c_password" scope="request"/>
						<c:set var="field_label" value="Confirm Password" scope="request"/>
						<c:set var="field_placeholder" value="Confirm Password" scope="request"/>
						<jsp:include page="../../../form_sections/password.jsp"></jsp:include>					
					</c:if>
					
					
					<jsp:include page="../../../form_sections/button.jsp"></jsp:include>
				
				</form:form>
				
				</div>

             </div>

         </div>

     </div>

 </div> 