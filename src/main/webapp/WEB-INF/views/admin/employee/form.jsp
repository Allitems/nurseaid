<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="search.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-md-12 col-sm-12" id="e_details">
			<div class="col-md-4 no_margin no_padding">
				<div class="panel panel-primary">
					<h2 class="text-left panel-heading no-mr-h2">Employee Details</h2>
					<div class="panel-body" style="height: 537px;">
						<form class="form-horizontal" method="post">
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Employee
									ID:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="employee_id"
										placeholder="U0001">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Active:</label>
								<div class="col-md-7 col-sm-6">
									<input type="checkbox" class="form-control" checked="">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">First
									Name:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="first_name"
										placeholder="John">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Last
									Name:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="Last_name"
										placeholder="Smith">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Gender:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="gender"
										placeholder="Male">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Maximum
									hours per fortnight:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="max_hour_pay"
										placeholder="76">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Date of
									Birth:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="dob"
										placeholder="11/01/1980">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Start
									Date:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="start_date"
										placeholder="11/01/2016">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Created
									Date:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="created_date"
										placeholder="30/06/2016">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Nationality:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="nationality"
										placeholder="Australian">
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
			<div class="col-md-4">
				<div class="panel panel-primary">
					<h2 class="text-left panel-heading no-mr-h2">Contact Details</h2>
					<div class="panel-body" style="height: 537px;">
						<form class="form-horizontal" method="post">
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Email
									Address:</label>
								<div class="col-md-7 col-sm-6">
									<input type="email" class="form-control" name="email_address"
										placeholder="JohnSmith@hotmail.com">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Mobile
									Number:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="mobile_number"
										placeholder="0404040404">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Home
									Phone:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="home_phone"
										placeholder="0505050505">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Work
									Phone:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="work_phone"
										placeholder="0707070707">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Address
									1:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="address_1"
										placeholder="1 Wiils Street">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Address
									2:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="address 2"
										placeholder="2 Wiils Street">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Suburb:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="suburb"
										placeholder="Wanniassa">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">State:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="state"
										placeholder="ACT">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Postcode:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="postcode"
										placeholder="2604">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 col-sm-6 control-label">Country:</label>
								<div class="col-md-7 col-sm-6">
									<input type="text" class="form-control" name="country"
										placeholder="Australian">
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
			<div class="col-md-4 no_margin no_padding">
				<div class="panel panel-primary">
					<h2 class="text-left panel-heading no-mr-h2">Photo</h2>
					<div class="panel-body text-center" style="height: 537px;">
						<img src="<c:url value="/resources/images/dummyimage.jpg" />"
							alt="Photo" class="img-responsive img-thumbnail">
						<h2>John Smith</h2>
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