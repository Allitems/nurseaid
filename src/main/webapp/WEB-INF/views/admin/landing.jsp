<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">

            <div class="col-md-offset-9 col-sm-offset-9 col-md-3 col-sm-3 text-right log-out-button">

                <a href="<c:url value='/logout'/>" class="btn-danger"><i class="fa fa-sign-out"></i>Log Out</a>

            </div>

        </div>

    </div><!--row ends-->

</div><!--container ends-->

<div class="container">

    <div class="row">

        <div class="col-md-12">

            

            <div class="panel panel-primary welcome">

                <h2 class="panel-heading text-center no-mr-h2">Welcome (${logged_in_user.getFull_name()})</h2>

                <div class="panel-body">
                
                	<div class="col-md-4 pull-left welcome-block">

                        <a href="<c:url value='/admin/site'/>">

                            <i class="fa fa-gear"></i>
							<br/>
                            Site Administration

                        </a> 

                    </div>

                    <div class="col-md-4 welcome-block">

                        <a href="<c:url value='/admin/employee'/>">

                            <i class="fa fa-users"></i>
							<br/>
                            Employee

                        </a>

                    </div>

                    <div class="col-md-4 pull-right welcome-block">

                        <a href="<c:url value='/admin/employer'/>">

                            <i class="fa fa-hospital-o"></i>
							<br/>
                            Employer

                        </a> 

                    </div>



                </div>

            </div>

        </div>

        <div class="col-md-2"></div>

    </div>

</div>