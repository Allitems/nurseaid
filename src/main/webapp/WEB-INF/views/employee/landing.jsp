<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">

            <div class="col-md-3 col-sm-6">

                <div class="panel panel-danger">

                    <h2 class="text-center panel-heading no-mr-h2">My Profile</h2>

                    <div class="panel-body">

                        <div class="ae-employee text-center">

                            <a href="<c:url value='/employee/my_profile'/>">

                                <i class="fa fa-user-plus"></i>

                                <i class="fa fa-pencil-square-o"></i>

                                <h4>Edit My Profile</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>
            
            
            <div class="col-md-3 col-sm-6">

                <div class="panel panel-danger">

                    <h2 class="text-center panel-heading no-mr-h2">Job History</h2>

                    <div class="panel-body">

                        <div class="ae-employee text-center">

                            <a href="<c:url value='/employee/job_history'/>">

                                <i class="fa fa-user-plus"></i>

                                <i class="fa fa-pencil-square-o"></i>

                                <h4>Job History</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>


        </div>

    </div>

</div>