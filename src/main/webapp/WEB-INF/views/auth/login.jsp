<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/login" var="actionURL" />

<div class="container">

     <div class="row">

         <div class="col-md-12 col-sm-12 no_padding">

             <div class="col-md-8">

                 <div class="panel panel-primary">

                     <h2 class="panel-heading no-mr-h2"><i class="fa fa-lock"></i>Login</h2>

                     <div class="panel-body">

                         <div class="col-md-10">
                         
                         	<c:set var="box_width" value="1" scope="request"/>
                         	<jsp:include page="../panels/message.jsp"></jsp:include>

                             <section class="login-form">
									<form:form method="post" modelAttribute="ObjForm" action="${actionURL}" role="login">

										<spring:bind path="username">
										  <div class="form-group">					  
										  		<label class="col-md-3 col-sm-3 control-label">Username :</label>
										        <div class="col-sm-9 col-sm-9">
										        	<form:input path="username" class="form-control" id="username" placeholder="Username" />
													<form:errors path="username" class="control-error login" />
										        </div>
										  </div>
										</spring:bind>
										
                                     
                                    	<spring:bind path="password">
										  <div class="form-group">					  
										  		<label class="col-md-3 col-sm-3 control-label">Password :</label>
										        <div class="col-sm-9 col-sm-9">
										        	<form:password path="password" class="form-control" id="password" placeholder="Password" />
													<form:errors path="password" class="control-error login" />
										        </div>
										  </div>
										</spring:bind>
									

                                     <div class="col-md-12 login-links">

                                         <a href="<c:url value='/forgot_password'/>" class="btn-block">Forgot password?</a>

                                         <a href="<c:url value='/employee/register'/>" class="btn-block">Register as employee</a>

                                         <a href="<c:url value='/employer/register'/>" class="btn-block">Register as employer</a>

                                     </div>

                                     <div class="text-right">

                                         <button type="submit" class="btn btn-primary">Sign-in</button>

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

             <div class="col-md-4 home-block-intro">
                 <h1 class="website-info">${content.getTitle()}</h1>
                 <p>${content.getContent()}</p>
             </div>

         </div><!--col-md-12 ends-->

     </div><!--row ends-->

 </div><!--container ends-->
 