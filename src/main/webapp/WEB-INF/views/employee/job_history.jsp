<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="container">

     <div class="row">

         <div class="col-md-12 col-sm-12">

             <div class="panel panel-primary">

                 <div class="panel-body">

                     <form class="employee-search form-horizontal" method="post">
                        
                         
                         <div class="col-md-6">
		                         <div class="form-group">
		
		                             <label class="col-md-3 col-sm-3 control-label" style="text-align: left;">Timesheet for : </label>
		
		                             <div class="col-md-9 col-sm-9">
		
		                                 <div class="input-group date">
		
		                                     <input type="text" class="form-control" name="job_ref" placeholder="Employee Name">
		
		                                     <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		
		
		
		                                 </div>
		                                 <div class="col-md-12 col-sm-12" style="padding-top: 10px; padding-bottom: 10px; text-align: center;">
		
			                                 <span class="option-or">OR</span>
			
			                             </div>
			                        </div>
			                             <label class="col-md-3 col-sm-3 control-label" style="text-align: left;">Employee ID : </label>
			                             
									 <div class="col-md-9 col-sm-9">
			                             <div class="col-md-12 col-sm-12 no_padding">
		
			
			                                     <input type="text" class="form-control" name="job_ref" placeholder="Employee ID">			
			
			
			                             </div>
		
		                             </div>  
		
		                         </div>
						</div>
						 
						 <div class="col-md-6">
		                         <div class="form-group">
		
		                             <label class="col-md-3 col-sm-3 control-label">Period: </label>
		
		                             <div class="col-md-9 col-sm-9">
		
		                                 <div class="input-group date">
		
		                                     <input type="text" class="form-control">
		
		                                     <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		
		
		
		                                 </div>
		                                 <div class="col-md-12 col-sm-12" style="padding-top: 10px; padding-bottom: 10px; text-align: center;">
		
			                                 <span class="option-or">OR</span>
			
			                             </div>
			
			                             <div class="col-md-12 col-sm-12 no_padding">
		
			                                 <div class="input-daterange input-group" id="datepicker">
			
			                                     <input type="text" class="input-sm form-control" name="start" />
			
			                                     <span class="input-group-addon">to</span>
			
			                                     <input type="text" class="input-sm form-control" name="end" />
			
			
			
			                                 </div>
			
			                             </div>
		
		                             </div>
		
		                             
		
		                             
		
		                         </div>
						</div>


                         <div class="text-center submit-button col-md-12">

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

                     <th>Employee</th>
                     
                     <th>Start</th>
                     
                     <th>End</th>
                     
                     <th>Role</th>
                     
                     <th>Site</th>

                     <th>Duration</th>

                     <th>Break</th>

                     <th>PH 150</th>

                     <th>OT 1.5</th>

                     <th>OT 2</th>

                     <th>50% Sat</th>
                     
                     <th>75% Sun</th>
                     
                     <th>Roster</th>
                     
                     <th>+/-</th>

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
