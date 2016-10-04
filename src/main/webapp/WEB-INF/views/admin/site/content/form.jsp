<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:choose>
    <c:when test="${btn_text eq 'Add'}">
    	<spring:url value="/admin/site/content/add" var="actionURL" />
    </c:when>
    <c:otherwise>
    	<spring:url value="/admin/site/content/edit/${TblCmsForm.getId()}" var="actionURL" />
    </c:otherwise>
</c:choose>

<jsp:include page="../../../panels/message.jsp"></jsp:include>

<div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">
             	<div class="panel-body">
				
				<form:form method="post" modelAttribute="TblCmsForm" action="${actionURL}">
				
					<form:hidden path="id" />
					
					<c:set var="field_name" value="title" scope="request"/>
					<c:set var="field_label" value="Title" scope="request"/>
					<c:set var="field_placeholder" value="Title" scope="request"/>
					<jsp:include page="../../../form_sections/textfield.jsp"></jsp:include>
					
					
					
					<c:set var="field_name" value="content" scope="request"/>
					<c:set var="field_label" value="Content" scope="request"/>
					<c:set var="field_placeholder" value="Content" scope="request"/>
					<jsp:include page="../../../form_sections/textarea.jsp"></jsp:include>
					
					
					<jsp:include page="../../../form_sections/button.jsp"></jsp:include>
				
				</form:form>
				
				</div>

             </div>

         </div>

     </div>

 </div>
 
 <script type="text/javascript">
 tinymce.init({ selector:'textarea#content',height: 300, width: '100%',
	  plugins: [
	            'advlist autolink lists link image charmap print preview anchor',
	            'searchreplace visualblocks code fullscreen',
	            'insertdatetime media table contextmenu paste code'
	          ],
	          toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
 });
 </script>
 