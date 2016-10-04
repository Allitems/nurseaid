<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <div class="row">

        <div class="col-md-12">

            <div class="panel panel-primary">

                <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                    <thead>

                        <th>No.</th>

                        <th>Name</th>

                        <th>Employee ID</th>

                        <th>Alert Message</th>

                        <th>Alert Employee</th>

                        <th>Status</th>

                    </thead>

                    <tbody>

                        <tr>

                            <td>1</td>

                            <td>John Smith</td>

                            <td>U001</td>

                            <td>Police Check about to expire</td>

                            <td class="email-alert"><a href="#">Send email alert</a></td>

                            <td>Pending</td>

                        </tr>

                        <tr>

                            <td>1</td>

                            <td>John Smith</td>

                            <td>U001</td>

                            <td>Police Check about to expire</td>

                            <td class="email-alert"><a href="#">Send email alert</a></td>

                            <td>Pending</td>

                        </tr>

                        <tr>

                            <td>1</td>

                            <td>John Smith</td>

                            <td>U001</td>

                            <td>Police Check about to expire</td>

                            <td class="email-alert"><a href="#">Send email alert</a></td>

                            <td>Pending</td>

                        </tr>

                    </tbody>

                </table>

               

            </div>

             <a href="#" class="btn-danger send-to-all">Send alert email to all</a>

        </div>

    </div>

</div>