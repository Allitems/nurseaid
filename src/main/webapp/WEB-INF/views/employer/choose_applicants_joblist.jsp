<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">

                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>

                     <th>Job Ref.</th>
                     
                     <th>Quantity</th>

                     <th>Job Date</th>

                     <th>Shift</th>

                     <th>Job Position</th>

                     <th>Applicants</th>

                     </thead>

                     <tbody>

						<c:choose>
						      <c:when test="${not empty jobs}">
						      		<c:forEach var="item" items="${jobs}">
										<tr>
				                             <td>${item.getReferenceNumber()}</td>				
				                             <td>${item.getQuantity()}</td>				
				                             <td>${item.getJobDate()}</td>
				                             <td>${item.getShiftFrom()} to ${item.getShiftTo()}</td>
				                             <td>${item.getTblJobPosition().getTitle()}</td>
				                             <td>
				                             	<c:choose>
					                             	<c:when test="${item.getCount_x() gt 1}">
					                             		<a style="width: 100%;" class="btn btn-primary" href="<c:url value='/console/employer/choose_applicants/${item.getId()}'/>">
					                             			${item.getCount_x()} Applicants
					                             		</a>				                             		
					                             	</c:when>
					                           		<c:otherwise>
					                           			<a style="width: 100%;" class="btn btn-primary" href="<c:url value='/console/employer/choose_applicants/${item.getId()}'/>">
					                             			${item.getCount_x()} Applicant&nbsp;
					                             		</a>
					                           		</c:otherwise>
					                           	</c:choose>			                             	
				                             </td>
				                         </tr>
									</c:forEach>
						      </c:when>
						      <c:otherwise>
						      		<tr>
			                             <td colspan="6">No Results to Display</td>
				                    </tr>
						      </c:otherwise>
					   	 </c:choose>

                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>

 <style type="text/css">
 #nurse-table td{vertical-align: middle;}
 </style>