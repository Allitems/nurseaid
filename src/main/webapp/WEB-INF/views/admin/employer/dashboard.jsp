<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="search.jsp"></jsp:include>

<div class="container">

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">

            <div class="col-md-3 col-sm-6">

                <div class="panel panel-danger">

                    <h2 class="text-center panel-heading no-mr-h2">Employer</h2>

                    <div class="panel-body">

                        <div class="ae-employee text-center">

                            <a href="<c:url value='/admin/employer/add'/>">

                                <i class="fa fa-user-plus"></i>

                                <i class="fa fa-pencil-square-o"></i>

                                <h4>Add Employer</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>

            
            <div class="col-md-3 col-sm-6">

                <div class="panel panel-info">

                    <h2 class="text-center panel-heading no-mr-h2">Reports</h2>

                    <div class="panel-body">

                        <div class="timesheet-summary text-center">

                            <a href="<c:url value='/admin/employee/timesheetsummary'/>">

                                <i class="fa fa-file-text-o"></i>

                                <h4>Department Timesheets</h4>

                            </a>

                        </div>

                        <div class="all-jobs text-center">

                            <a href="<c:url value='/admin/employee/alljobs'/>">

                                <i class="fa fa-eye"></i>

                                <h4>All Jobs</h4>

                            </a>

                        </div>

                    </div>

                    

                </div><!--paneel info ends-->

              

            </div>

        </div>

    </div>

</div>