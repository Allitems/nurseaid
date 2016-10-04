<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">

                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>
						<tr>
		                     <th>&nbsp;</th>		
		                     <th>Employee</th>
		                     <th>Date</th>
		                     <th>Start</th>                     
		                     <th>End</th>                     
		                     <th>Role</th>                     
		                     <th>Job Ref</th>
		                     <th>Duration</th>
		                     <th>Break</th>
		                     <th>PH 150</th>
		                     <th>OT 1.5</th>
		                     <th>OT 2</th>
		                     <th>50% Sat</th>                     
		                     <th>75% Sun</th>                     
		                     <th>Roster</th>                     
		                     <th>Action</th>
						</tr>
                     </thead>

                     <tbody>
							<c:forEach var="item" items="${list}">
								<tr>							
		                             <td class="status-code yellow">
		                             IM
		                             </td>
									<td>
									${item.getTblEmployee().getFirstName()} ${item.getTblEmployee().getLastName()}
									</td>
									<td>
									${item.getTblJob().getJobDate()}
									</td>
									<td>
									${item.getTblJob().getShiftFrom()}
									</td>
									<td>
									${item.getTblJob().getShiftTo()}
									</td>
									<td>
									${item.getTblJob().getTblJobPosition().getTitle()}
									</td>
									<td>
									${item.getTblJob().getReferenceNumber()}
									</td>
									<td>?</td>
									<td>?</td>
									<td>?</td>
									<td>?</td>
									<td>?</td>
									<td>?</td>
									<td>?</td>
									<td>
									${item.getTblJob().getShiftFrom()} - ${item.getTblJob().getShiftTo()}
									</td>
		                             <td>
			                             <a onclick="alert('Working...'); return false;" style="width: 100%;" class="btn btn-primary" href="<c:url value='/console/employer/invoice/${item.getId()}'/>">
	                             			Invoice
	                             		 </a>
		                             </td>
		                         </tr>
							</c:forEach>
                         

                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>
