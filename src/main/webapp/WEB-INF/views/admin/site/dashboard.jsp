<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container dashboard">

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">

            <div class="col-md-3 col-sm-6">

                <div class="panel panel-danger">

                    <h2 class="text-center panel-heading no-mr-h2">Users</h2>

                    <div class="panel-body">

                        <div class="ae-employee text-center">

                            <a href="<c:url value='/admin/site/user'/>">

                                <i class="fa fa-user-plus"></i>

                                <h4>Admin User Management</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>

            <div class="col-md-3 col-sm-6">

                <div class="panel panel-warning">

                    <h2 class="text-center panel-heading no-mr-h2">Content</h2>

                    <div class="panel-body">

                        <div class="payslips text-center">

                            <a href="<c:url value='/admin/site/content'/>">

                                <i class="fa fa-file-text-o"></i>

                                <h4>Content Management</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>

            <div class="col-md-3 col-sm-6">

                <div class="panel panel-success">

                    <h2 class="text-center panel-heading no-mr-h2">Settings</h2>

                    <div class="panel-body">

                        <div class="alerts text-center">

                            <a href="<c:url value='/admin/site/settings'/>">

                                <i class="fa fa-gear"></i>

                                <h4>Application Settings</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>
            
            
            <div class="col-md-3 col-sm-6">

                <div class="panel panel-info">

                    <h2 class="text-center panel-heading no-mr-h2">Documents</h2>

                    <div class="panel-body">

                        <div class="info text-center">

                            <a href="<c:url value='/admin/site/doctype'/>">

                                <i class="fa fa-file-archive-o"></i>

                                <h4>Document Types</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>
            
            
            <div class="col-md-3 col-sm-6">

                <div class="panel panel-success">

                    <h2 class="text-center panel-heading no-mr-h2">Messages</h2>

                    <div class="panel-body">

                        <div class="alerts text-center">

                            <a href="<c:url value='/admin/site/message'/>">

                                <i class="fa fa-envelope-o"></i>

                                <h4>Messages & Notifications</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>
            
            
            <div class="col-md-3 col-sm-6">

                <div class="panel panel-info">

                    <h2 class="text-center panel-heading no-mr-h2">Job Positions</h2>

                    <div class="panel-body">

                        <div class="info text-center">

                            <a href="<c:url value='/admin/site/job_position'/>">

                                <i class="fa fa-group"></i>

                                <h4>Job Positions Management</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>
            
            
            <div class="col-md-3 col-sm-6">

                <div class="panel panel-danger">

                    <h2 class="text-center panel-heading no-mr-h2">Country</h2>

                    <div class="panel-body">

                        <div class="ae-employee text-center">

                            <a href="<c:url value='/admin/site/country'/>">

                                <i class="fa fa-university"></i>

                                <h4>Country & Nationality</h4>

                            </a>

                        </div>

                    </div>

                </div>

            </div>


        </div>

    </div>

</div>