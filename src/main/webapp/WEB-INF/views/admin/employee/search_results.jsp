<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="search.jsp"></jsp:include>

<div class="container" style="padding-bottom: 20px;">

    <div class="row">
        <div class="col-md-12 col-sm-12">
        	Search Results for : ${q}
        </div>
    </div>
</div>

<div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">

                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>

                     <th>Employee ID</th>
                     <th>Employee Name</th>
                     <th>Joined On</th>                     
                     <th>Status</th>                     
                     <th>Action</th>

                     </thead>

                     <tbody>
                     
                     	<c:choose>
						      <c:when test="${not empty list}">
						      		<c:forEach var="item" items="${list}">
										<tr>
										     <td>${item.getTblEntityAbstract().getEntityCode()}</td>				
				                             <td>${item.getFirstName()} ${item.getLastName()}</td>				
				                             <td>${item.getDate_string()}</td>				
				                             <td>${item.getTblEntityAbstract().getStatus()}</td>				
				                             <td>
				                             	<a href="<c:url value='/admin/employee/edit/${item.getId()}'/>" class="btn btn-info">Edit</a>
				                             	<a href="<c:url value='/admin/employee/delete/${item.getId()}'/>" class="btn btn-danger">Delete</a>
				                             </td>				
				                         </tr>
									</c:forEach>
						      </c:when>
						      <c:otherwise>
						      		<tr>
			                             <td colspan="5">No Results to Display</td>
				                    </tr>
						      </c:otherwise>
					   	 </c:choose>    

                         
                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>
