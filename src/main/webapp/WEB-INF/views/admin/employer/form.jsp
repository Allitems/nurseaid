<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="search.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<div class="col-md-12 col-sm-12" id="e_details">
			<div class="col-md-4 no_margin no_padding">
				<div class="panel panel-primary">
					<h2 class="text-left panel-heading no-mr-h2">Employer Details</h2>
					<div class="panel-body">
<form class="form-horizontal" method="post">
<div class="form-group">
	<label class="col-md-5 col-sm-6 control-label">Employer ID:</label>
	<div class="col-md-7 col-sm-6">
		<input type="text" class="form-control" name="employee_id" placeholder="U0001">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-5 col-sm-6 control-label">Active:</label>
		<div class="col-md-7 col-sm-6">
			<input type="checkbox" class="form-control" checked="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-5 col-sm-6 control-label">Company Name:</label>
			<div class="col-md-7 col-sm-6">
				<input type="text" class="form-control" name="company_name" placeholder="John">
				</div>
			</div>

						<div class="form-group">
							<label class="col-md-5 col-sm-6 control-label">Date Joined:</label>
							<div class="col-md-7 col-sm-6">
								<input type="text" class="form-control" name="dob" placeholder="11/01/1980">
								</div>
							</div>
		
								<div class="form-group">
									<label class="col-md-5 col-sm-6 control-label">Created Date:</label>
									<div class="col-md-7 col-sm-6">
										<input type="text" class="form-control" name="created_date" placeholder="30/06/2016">
										</div>
									</div>
			
									</form>
<!--form Ends-->
</div>
<!--panel body --ends-->
</div>
<!--panel primary ends-->
</div>
<!--col-md-4-- ends-->
<div class="col-md-5">
	<div class="panel panel-primary">
		<h2 class="text-left panel-heading no-mr-h2">Contact Details</h2>
		<div class="panel-body">
<form class="form-horizontal" method="post">
<div class="form-group">
	<label class="col-md-5 col-sm-6 control-label">Email Address:</label>
	<div class="col-md-7 col-sm-6">
		<input type="email" class="form-control" name="email_address" placeholder="JohnSmith@hotmail.com">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-5 col-sm-6 control-label">Contact Person:</label>
		<div class="col-md-7 col-sm-6">
			<input type="text" class="form-control" name="mobile_number" placeholder="0404040404">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-5 col-sm-6 control-label">Contact Person Position:</label>
			<div class="col-md-7 col-sm-6">
				<input type="text" class="form-control" name="home_phone" placeholder="0505050505">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-5 col-sm-6 control-label">Mobile Number:</label>
				<div class="col-md-7 col-sm-6">
					<input type="text" class="form-control" name="mobile_number" placeholder="0404040404">
					</div>
				</div>
			<div class="form-group">
				<label class="col-md-5 col-sm-6 control-label">Work Phone:</label>
				<div class="col-md-7 col-sm-6">
					<input type="text" class="form-control" name="work_phone" placeholder="0707070707">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-5 col-sm-6 control-label">Address 1:</label>
					<div class="col-md-7 col-sm-6">
						<input type="text" class="form-control" name="address_1" placeholder="1 Wiils Street">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 col-sm-6 control-label">Address 2:</label>
						<div class="col-md-7 col-sm-6">
							<input type="text" class="form-control" name="address 2" placeholder="2 Wiils Street">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-5 col-sm-6 control-label">Suburb:</label>
							<div class="col-md-7 col-sm-6">
								<input type="text" class="form-control" name="suburb" placeholder="Wanniassa">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">State:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="state" placeholder="ACT">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 col-sm-6 control-label">Postcode:</label>
									<div class="col-md-7 col-sm-6">
										<input type="text" class="form-control" name="postcode" placeholder="2604">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 col-sm-6 control-label">Country:</label>
										<div class="col-md-7 col-sm-6">
											<input type="text" class="form-control" name="country" placeholder="Australian">
											</div>
										</div>
									</form>
				<!--form Ends-->
			</div>
			<!--panel body --ends-->
		</div>
		<!--panel primary ends-->
	</div>
	<!--col-md-4-- ends-->
	<div class="col-md-3 no_margin no_padding">
		<div class="panel panel-primary">
			<h2 class="text-left panel-heading no-mr-h2">Jindalee Nursing home</h2>
			<div class="panel-body text-center" style="height: 537px;">
				<a href="#" class="btn btn-primary">Timesheets</a>
				</div>
			</div>
		</div>
	</div>
	<!--col-md-12 ends-->
</div>
<!--row ends-->
</div>

<jsp:include page="form_section.jsp"></jsp:include>

<script type="text/javascript">            
	$(document).ready(function()
	{
		equalize('#e_details .panel-body')            
	});        
</script>