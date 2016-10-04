<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="/console/employer/landing" var="actionURL" />

<div class="container">

    <div class="row">

        <div class="col-md-9 col-sm-8">

            <div class="panel panel-primary">

                <h2 class="text-left panel-heading no-mr-h2">Publish New Job</h2>

                <div class="panel-body">                
                	
                	<c:set var="box_width" value="yes" scope="request"/>
                	<jsp:include page="../panels/message.jsp"></jsp:include>

                    <form:form method="post" modelAttribute="ObjForm" action="${actionURL}">
						
						<c:set var="field_name" value="quantity" scope="request"/>
						<c:set var="field_label" value="Quantity" scope="request"/>
						<c:set var="field_placeholder" value="Quantity" scope="request"/>
						<jsp:include page="../form_sections/textfield.jsp"></jsp:include>
						
						
						<c:set var="field_name" value="position" scope="request"/>
						<c:set var="field_label" value="Position" scope="request"/>
						<c:set var="list_of_values" value="${list_position}" scope="request"/>
						<jsp:include page="../form_sections/dropdown.jsp"></jsp:include>
	
						
						<c:set var="field_name_from" value="shift_from" scope="request"/>
						<c:set var="field_name_to" value="shift_to" scope="request"/>
						<c:set var="field_label" value="Shift" scope="request"/>						
     					<jsp:include page="../form_sections/timepicker_range.jsp"></jsp:include>
                        
                        <c:set var="field_name" value="job_date" scope="request"/>
						<c:set var="field_label" value="Date" scope="request"/>
						<c:set var="field_placeholder" value="Date" scope="request"/>
                        <jsp:include page="../form_sections/datepicker.jsp"></jsp:include>
                        

                        <div class="display-message"></div>

                        <div id="step_1" class="form-group text-right">

                            <button id="btn_publish" type="button" class="btn btn-primary btn-lg">Publish</button>

                        </div>
                        
                        <div id="step_2" class="form-group text-right">
							
							<button id="btn_cancel" type="button" class="btn btn-danger btn-lg">Cancel</button>
                            <button type="submit" class="btn btn-primary btn-lg">Confirm</button>

                        </div>

                    </form:form>

                </div>

            </div>

        </div><!--col-md-9--ends-->

<style type="text/css">
#step_2, .display-message{display: none;}
</style>     
   
<script type="text/javascript">
$(document).ready(function(){
	$('#btn_publish').click(function(){
		
		qty = $('#quantity').val();
		position = $('#position option:selected').text();
		shift_from = $('#shift_from').val();
		shift_to = $('#shift_to').val();
		date_x = $('#job_date').val();
		
		$('.display-message').html(qty + " " + position + " for the shift " + shift_from + " - " + shift_to + " on " + date_x);
		
		$('.display-message').fadeIn();
		
		$('#step_1').fadeOut('medium', function(){
			$('#step_2').fadeIn();
		});
	});
	
	$('#btn_cancel').click(function(){
		
		$('.display-message').html("");
		
		$('.display-message').fadeOut();
		
		$('#step_2').fadeOut('medium', function(){
			$('#step_1').fadeIn();
		});
	});
});
</script>

        <aside class="col-md-3 col-sm-4">

            <div class="panel panel-danger">

                <h2 class="text-center panel-heading no-mr-h2">Alert</h2>

                <div class="panel-body text-center">

                    <div class="job-complete">

                        <a href="<c:url value='/console/employer/job_completion_alert'/>">
							<c:if test="${job_completion_alert_count gt 0}">
						    	   <span class="notification-number">${job_completion_alert_count}</span>
							</c:if>

                            <i class="fa fa-file-text"></i>

                            <h4>Job Completion Alert</h4>

                        </a>

                    </div>

                    <div class="applicants">

                        <a href="<c:url value='/console/employer/choose_applicants/joblist'/>">
							<c:if test="${new_applicant_count gt 0}">
						    	   <span class="notification-number">${new_applicant_count}</span>
							</c:if>
                            <i class="fa fa-search"></i>

                            <h4>Choose Applicants</h4>

                        </a>

                    </div>

                </div>

            </div>

            <div class="panel panel-info">

                <h2 class="text-center panel-heading no-mr-h2">Reports</h2>

                <div class="panel-body text-center">

                    <div class="report">

                        <a href="<c:url value='/console/employer/all_jobs_timesheets'/>">
                            <i class="fa fa-eye"></i>

                            <h4>All Jobs / Timesheets</h4>

                        </a>

                    </div>

                </div>

            </div>

        </aside>

    </div><!--row ends-->

</div><!--container ends-->

