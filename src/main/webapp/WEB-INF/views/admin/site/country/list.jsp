<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="padding-bottom: 20px;">
    <div class="row">
        <div class="col-md-12 col-sm-12">
			<a href="<c:url value='/admin/site/country/add'/>" class="btn btn-info">Add Country</a>
        </div>
    </div>
</div>


<jsp:include page="../../../panels/message.jsp"></jsp:include>


<div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">
             	
                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>

                     <th>Name</th>

                     <th>Nationality</th>
                     
                     <th>Action</th>

                     </thead>

                     <tbody>
	                     <c:choose>
						      <c:when test="${not empty list}">
						      		<c:forEach var="item" items="${list}">
										<tr>
				                             <td>${item.getTitle()}</td>				
				                             <td>${item.getNationality()}</td>
				                             <td>
				                             	<a href="<c:url value='/admin/site/country/edit/${item.getId()}'/>" class="btn btn-info">Edit</a>
				                             	<a onclick="return confirm('Do you want to delete this record?');" href="<c:url value='/admin/site/country/delete/${item.getId()}'/>" class="btn btn-danger">Delete</a>
				                             </td>
				
				                         </tr>
									</c:forEach>
						      </c:when>
						      <c:otherwise>
						      		<tr>
			                             <td colspan="3">No Results to Display</td>
				                    </tr>
						      </c:otherwise>
					   	 </c:choose>                      

                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>
