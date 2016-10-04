<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${empty box_width}">
		<c:set var="container_class" value="container" scope="request"/>
	</c:when>
	<c:otherwise>
		<c:set var="container_class" value="no_container" scope="request"/>
	</c:otherwise>
</c:choose>

<c:if test="${not empty msg}">
	<div class="${container_class}">
	    <div class="row">
	        <div class="col-md-12 col-sm-12">
				<div class="alert alert-${css} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<strong>${msg}</strong>
				</div>
			</div>
	    </div>
	</div>
</c:if>