<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" style="margin-top: 2%;">

    <div class="row">
		
		 <div class="col-md-2 col-sm-2">
		 </div>
        <div class="col-md-8 col-sm-8">

            <div class="panel panel-primary">

                <h2 class="text-left panel-heading no-mr-h2">System Message</h2>

                <div class="panel-body">                
                	${message}
                	<br/><br/>
                	<div class="text-center">
	                	<a class="btn btn-primary" href="<c:url value='/console/employer/landing'/>">
	                		Go to Dashboard
	                	</a>
	                </div>	
                </div>
                

            </div>

        </div><!--col-md-9--ends-->
		
		<div class="col-md-2 col-sm-2">
		 </div>

    </div><!--row ends-->

</div><!--container ends-->

