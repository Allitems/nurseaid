<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container margin-bottom-25">

    <div class="row">

        <div class="col-md-12 col-sm-12">

        <div class="panel-body bg-info">			
			${content.getContent()}
        </div>

        </div>

    </div>

</div><!--Registration information block ends-->

<spring:url value="/employer/register" var="actionURL" />

<jsp:include page="../panels/message.jsp"></jsp:include>

<div class="container">

    <div class="row">

        <div class="col-md-12 col-sm-12">

            <div class="panel panel-primary">

            <!--<h2 class="text-center"><i class="fa fa-hospital-o"></i></h2>-->

            <h2 class="text-left panel-heading no-mr-h2"><i class="fa fa-hospital-o"></i> Employer Registration</h2>

            <div class="panel-body">

            <form:form method="post" modelAttribute="ObjForm" action="${actionURL}" class="form-horizontal">
				
				<c:set var="is_front_end" value="yes" scope="request"/>
				
				<c:set var="field_name" value="company_name" scope="request"/>
				<c:set var="field_label" value="Company Name" scope="request"/>
				<c:set var="field_placeholder" value="Company Name" scope="request"/>
				<jsp:include page="../form_sections/textfield.jsp"></jsp:include>
				
               
                <c:set var="field_name" value="contact_person" scope="request"/>
				<c:set var="field_label" value="Contact Person" scope="request"/>
				<c:set var="field_placeholder" value="Contact Person" scope="request"/>
				<jsp:include page="../form_sections/textfield.jsp"></jsp:include>
				
				<c:set var="field_name" value="billing_email" scope="request"/>
				<c:set var="field_label" value="Email Address for Billing" scope="request"/>
				<c:set var="field_placeholder" value="Email" scope="request"/>
				<jsp:include page="../form_sections/textfield.jsp"></jsp:include>
				
				
				<c:set var="field_name" value="company_phone" scope="request"/>
				<c:set var="field_label" value="Company Number" scope="request"/>
				<c:set var="field_placeholder" value="Area Code - Landline Number" scope="request"/>
				<jsp:include page="../form_sections/textfield.jsp"></jsp:include>
				
				
				<c:set var="field_name" value="username" scope="request"/>
				<c:set var="field_label" value="Username" scope="request"/>
				<c:set var="field_placeholder" value="Username" scope="request"/>
				<jsp:include page="../form_sections/textfield.jsp"></jsp:include>
				
				
				<c:set var="field_name" value="password" scope="request"/>
				<c:set var="field_label" value="Password" scope="request"/>
				<c:set var="field_placeholder" value="Password" scope="request"/>
				<jsp:include page="../form_sections/password.jsp"></jsp:include>
				
				
				<c:set var="field_name" value="c_password" scope="request"/>
				<c:set var="field_label" value="Confirm Password" scope="request"/>
				<c:set var="field_placeholder" value="" scope="request"/>
				<jsp:include page="../form_sections/password.jsp"></jsp:include>
				
				
				<c:set var="field_name" value="address" scope="request"/>
				<c:set var="field_label" value="Address" scope="request"/>
				<c:set var="field_placeholder" value="" scope="request"/>
				<jsp:include page="../form_sections/textarea.jsp"></jsp:include>
				
				
                <div class="form-group">

                    <label class="col-md-3 col-sm-3 control-label"><h3>Attachments:</h3></label>

                    <div class="col-md-10 col-sm-9"></div>

                </div>     

                <div class="form-group">

                    <label class="col-md-3 col-sm-3 control-label">* Application form:</label>

                    <div class="col-md-4 col-sm-4">

                        <input type="file" name="app_form">

                    </div>

                </div>

                <div class="form-group">

                    <label class="col-md-3 col-sm-3 control-label">* Signed Contract:</label>

                    <div class="col-md-4 col-sm-4">

                        <input type="file" name="signed_contract">

                    </div>

                </div>

                <div class="form-group">

                    <label class="col-md-3 col-sm-3 control-label">* Other document1:</label>

                    <div class="col-md-4 col-sm-4">

                        <input type="file" name="other_doc1">

                    </div>

                </div>

                <div class="form-group">

                    <label class="col-md-3 col-sm-3 control-label">* Other document2:</label>

                    <div class="col-md-4 col-sm-4">

                        <input type="file" name="other_doc2">

                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-3 col-sm-3 control-label"></label>

                    <div class="col-md-4 col-sm-4">

                        <button type="submit" class="btn btn-primary btn-lg">Submit</button>

                    </div>
                

                </div>

            </form:form><!--form Ends-->

            </div><!--panel -body ends-->

            </div><!--panel ends-->

        </div><!--col-md-12--ends-->

    </div><!--row ends-->

</div><!--container ends-->
