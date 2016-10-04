<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <div class="container">

     <div class="row">

         <div class="col-md-12 col-sm-12">

             <div class="panel panel-primary">

                 <div class="panel-body">
						
						<form:form method="post" modelAttribute="ObjForm" action="${actionURL}" class="employee-search form-horizontal">

                         <!--<div class="col-md-12">-->
                         
                         <spring:bind path="job_status">
							  <div class="form-group">					  
							  		<label class="col-md-2 col-sm-3 control-label">Job Status :</label>
							        <div class="col-md-4 col-sm-4">
							        	<form:select path="job_status" name="job_status" class="form-control" id="job_status" items="${list_of_job_status}" />
							        </div>
							  </div>
						</spring:bind>

						<spring:bind path="job_ref">
						  <div class="form-group">					  
						  		<label class="col-md-2 col-sm-3 control-label">Job Ref. :</label>
						        <div class="col-md-4 col-sm-4">
						        	<form:input path="job_ref" class="form-control" id="job_ref" placeholder="Job Reference Number" />
						        </div>
						  </div>
						</spring:bind>
						
						<spring:bind path="staff_name">
							  <div class="form-group">					  
							  		<label class="col-md-2 col-sm-3 control-label">Employee Name :</label>
							        <div class="col-md-4 col-sm-4">
							        	<form:input path="staff_name" placeholder="Employee Name" name="staff_name" class="form-control" id="staff_name" />
							        </div>
							  </div>
						</spring:bind>

                         <div class="form-group">
                         
                         
	                         <spring:bind path="point_date">
		  				  		<label class="col-md-2 col-sm-3 control-label">Period :</label>
						        <div class="col-md-4 col-sm-3">
						        	<div class="input-group date">
							        	<form:input path="point_date" placeholder="Job Date" name="point_date" class="form-control" id="point_date" />
							        	<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        	</div>
						        </div>
							</spring:bind>

                             <div class="col-md-1 col-sm-1 w_auto">

                                 <span class="option-or">OR</span>

                             </div>

                             <div class="col-md-5 col-sm-5">

                                 <div class="input-daterange input-group" id="datepicker2" data-date-format="dd-mm-yyyy">
										
									<spring:bind path="date_from">
								        <form:input path="date_from" placeholder="Job Date From" name="date_from" class="form-control" id="date_from" />
									</spring:bind>
                                     

                                     <span class="input-group-addon">to</span>

                                     <spring:bind path="date_to">
								        <form:input path="date_to" placeholder="Job Date To" name="date_to" class="form-control" id="date_to" />
									</spring:bind>

                                 </div>

                             </div>

                         </div>



                         <div class="text-center submit-button">

                             <button class="btn btn-primary btn-lg" type="submit">Search</button>

                         </div>

                     </form:form><!--form ends-->

                 </div>

             </div>

         </div><!--col-md-12--ends-->

     </div><!--row ends-->

 </div><!--container ends-->



 <div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">

                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>

                     <th>&nbsp;</th>
                     <th>Job Ref.</th>
                     <th>Job Date</th>
                     <th>Start Time</th>
                     <th>Finish Time</th>
                     <th>Alloted To</th>
                     <th>Status</th>

                     </thead>

                     <tbody>

							<c:choose>
						      <c:when test="${not empty list}">
						      		<c:forEach var="item" items="${list}">
										<tr>
				                             <td>&nbsp;</td>				
				                             <td>${item.getReferenceNumber()}</td>
											 <td>${item.getJobDate()}</td>
											 <td>${item.getShiftFrom()}</td>
											 <td>${item.getShiftTo()}</td>
											 <td>
											 	<c:choose>
											 		<c:when test="${item.getAllotted_to() != null}">
											 			${item.getAllotted_to().getTblEmployee().getFirstName()} ${item.getAllotted_to().getTblEmployee().getLastName()}
											 		</c:when>
											 		<c:otherwise>
											 			Not Assigned Yet
											 		</c:otherwise>
											 	</c:choose>
											 </td>
											 <td>
											 ${item.getJob_status_string()}
											 </td>
				                         </tr>
									</c:forEach>
						      </c:when>
						      <c:otherwise>
						      		<tr>
			                             <td colspan="8">No Results to Display</td>
				                    </tr>
						      </c:otherwise>
					   	 </c:choose> 

                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>
