<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
	<div class="row">
		<div class="col-md-12 col-sm-12">
			<div class="col-md-3 col-md-3 no_margin no_padding">
				<h3 class="ref-number">Ref : ${job.getReferenceNumber()}</h3>
				<h3 class="ref-number">Position : ${job.getTblJobPosition().getTitle()}</h3>
				<h3 class="ref-number">Shift :  ${job.getShiftFrom()} -  ${job.getShiftTo()}</h3>
				<h3 class="ref-number">Date : ${job.getDate_string()}</h3>
			</div>
			<div class="col-md-9">
				<table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">
					<thead>
						<th>Interested person</th>
						<th>Worked at your company</th>
						<th>Status</th>
					</thead>
					<tbody>
						
						<c:choose>
						      <c:when test="${not empty candidate_list}">
						      		<c:forEach var="item" items="${candidate_list}">
										<tr>
				                            <td>
				                            	${item.getTblEmployee().getFirstName()} ${item.getTblEmployee().getLastName()}
				                            </td>				
				                            <td>${item.getCount_x()}</td>
												<c:if test="${item.getJobStatus() == 0}">
													<td class="btn-accept">
														<a job_id="${item.getTblJob().getId()}" employee_id="${item.getTblEmployee().getId()}" href="#">
															Accept
														</a>
														<span>Updating Job Status...</span>
													</td>
												</c:if>
												<c:if test="${item.getJobStatus() == 1}">
													<td class="assigned-color">
														Assigned
													</td>
												</c:if>
												<c:if test="${item.getJobStatus() == 9}">
													<td class="declined-color">
														Declined
													</td>
												</c:if>
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

<script type="text/javascript">
$(document).ready(function(){
	$('.btn-accept a').hover(function(){
		$(this).html('Click here to confirm');
	}, function(){
		$(this).html('Accept');
	});
	
	$('.btn-accept a').click(function(){
		
		showLoadingStatus();
		
		job_id = $(this).attr('job_id');
		employee_id = $(this).attr('employee_id');
		
		console.log(job_id+" "+employee_id);
		
		$.ajax({
			  type: "POST",
			  url: "<c:url value='/console/employer/assign_job'/>",
			  data: { job_id : job_id, employee_id : employee_id },
			  success: function( data ) {
				     if(data.success == 1)
				    	 {
				    	 	$('.btn-accept').each(function(k, v){
				    			a = $(v).find('a');
				    			if($(a).attr('job_id') == job_id && $(a).attr('employee_id') == employee_id)
				    			{
				    				$(v).addClass('assigned-color').removeClass('btn-accept');
				    				$(v).html('Assigned');
				    			}
				    			else
				    				{
				    					$(v).addClass('declined-color').removeClass('btn-accept');
				    					$(v).html('Declined');
				    				}
				    		});
				    	 }
				     else
				    	 {
				    	 	alert('Something went wrong...please try again');
				    	 	restoreLoadingStatus();
				    	 }
			  },
			  dataType: 'json'
			});
		
	});	
});

function showLoadingStatus()
{
	$('.btn-accept').each(function(k, v){
		$(this).find('a').hide();
		$(this).find('span').show();
	});
}

function restoreLoadingStatus()
{
	$('.btn-accept').each(function(k, v){
		$(this).find('a').show();
		$(this).find('span').hide();
	});
}
</script>