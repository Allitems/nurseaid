<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



 <div class="container">

     <div class="row">

         <div class="col-md-12 col-sm-12">

             <div class="panel panel-primary">

                 <div class="panel-body">

                     <form class="employee-search form-horizontal" method="post">

                         <!--<div class="col-md-12">-->

                         <div class="form-group">

                             <label class="col-md-2 col-sm-3 control-label">Job Status:</label>

                             <div class="col-md-4 col-sm-4">

                                 <select class="form-control" name="">

                                     <option>All</option>

                                     <option>Available</option>

                                     <option>Applied</option>

                                     <option>Pending</option>

                                     <option>Confirmed</option>

                                 </select>

                             </div>

                         </div>



                         <div class="form-group">

                             <label class="col-md-2 col-sm-3 control-label">Job Ref:</label>

                             <div class="col-md-4 col-sm-4">

                                 <input type="text" class="form-control" name="job_ref" placeholder="Enter Job Ref No.">

                             </div>

                         </div>

                         <div class="form-group">

                             <label class="col-md-2 col-sm-3 control-label">Job Posted By:</label>

                             <div class="col-md-4 col-sm-4">

                                 <input type="text" class="form-control" name="job_posted_by" placeholder="Enter Employer">

                             </div>

                         </div>

                         <div class="form-group">

                             <label class="col-md-2 col-sm-3 control-label">Staff Name:</label>

                             <div class="col-md-4 col-sm-4">

                                 <input type="text" class="form-control" name="Staff Name" placeholder="Enter Employer">

                             </div>

                         </div>

                         <div class="form-group">

                             <label class="col-md-2 col-sm-3 control-label">Period: </label>

                             <div class="col-md-4 col-sm-3">

                                 <div class="input-group date">

                                     <input type="text" class="form-control">

                                     <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>



                                 </div>

                             </div>

                             <div class="col-md-1 col-sm-1 w_auto">

                                 <span class="option-or">OR</span>

                             </div>

                             <div class="col-md-5 col-sm-5">

                                 <div class="input-daterange input-group" id="datepicker">

                                     <input type="text" class="input-sm form-control" name="start" />

                                     <span class="input-group-addon">to</span>

                                     <input type="text" class="input-sm form-control" name="end" />



                                 </div>

                             </div>

                         </div>



                         <div class="text-center submit-button">

                             <button class="btn btn-primary btn-lg" type="submit">Search</button>

                         </div>



                     </form><!--form ends-->

                 </div>

             </div>

         </div><!--col-md-12--ends-->

     </div><!--row ends-->

 </div><!--container ends-->



 <div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">

                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>

                     <th><input type="checkbox" id="checkall" /></th>

                     <th>Job Ref.</th>

                     <th>Job Date</th>

                     <th>Start Time</th>

                     <th>Finish Time</th>

                     <th>Posted By</th>

                     <th>Alloted To</th>

                     <th>Status</th>

                     </thead>

                     <tbody>



                         <tr>

                             <td><input type="checkbox" class="checkthis" /></td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                         </tr>

                         <tr>

                             <td><input type="checkbox" class="checkthis" /></td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                             <td>-</td>

                         </tr>

                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>
