<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/forgot_password" var="actionURL" />



<div class="container">

     <div class="row">

         <div class="col-md-12 col-sm-12 no_padding">

             <div class="col-md-8">

                 <div class="panel panel-primary">

                     <h2 class="panel-heading no-mr-h2"><i class="fa fa-lock"></i>Forgot Password</h2>

                     <div class="panel-body">

                         <div class="col-md-10">
                         
                         	<c:set var="box_width" value="1" scope="request"/>
                         	<jsp:include page="../panels/message.jsp"></jsp:include>

                             <section class="login-form">
								<form:form method="post" modelAttribute="ObjForm" action="${actionURL}" role="login">

                                     <spring:bind path="email">
									  <div class="form-group">					  
									  		<label class="col-md-3 col-sm-3 control-label">Email :</label>
									        <div class="col-sm-9 col-sm-9">
									        	<form:input path="email" class="form-control" id="email" placeholder="Email" />
												<form:errors path="email" class="control-error login" />
									        </div>
									  </div>
									</spring:bind>


                                     <div class="text-right">

                                         <button type="submit" class="btn btn-primary">Reset Password</button>
                                         <button type="button" onclick="document.location='<c:url value='/login'/>'; return false;" class="btn btn-danger">Cancel</button>

                                     </div>



                                 </form:form>

                             </section>

                         </div>

                         <div class="col-md-2 login-form-lock-icon">

                             <i class="fa fa-lock"></i>

                         </div>

                     </div><!--panel body ends-->

                 </div><!--panel panel primary ends-->

             </div><!--col -md-8 ends-->

             <div class="col-md-4">
             </div>

         </div><!--col-md-12 ends-->

     </div><!--row ends-->

 </div><!--container ends-->
 