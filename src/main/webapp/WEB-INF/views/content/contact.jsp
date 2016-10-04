<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/contact" var="actionURL" />

<div class="container">

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">

            <div class="col-md-6">

                <div class="panel panel-primary">

                    <h2 class="panel-heading no-mr-h2">Contact Us</h2>
                    
                    <jsp:include page="../panels/message.jsp"></jsp:include>

                    <div class="panel-body">

                        <section class="login-form">
							<form:form method="post" class="form-horizontal" modelAttribute="ObjForm" action="${actionURL}">
                            
                            	<c:set var="field_name" value="full_name" scope="request"/>
								<c:set var="field_label" value="Full Name" scope="request"/>
								<c:set var="field_placeholder" value="Full Name" scope="request"/>
								<jsp:include page="../form_sections/textfield_contact.jsp"></jsp:include>


                                <c:set var="field_name" value="email" scope="request"/>
								<c:set var="field_label" value="Email" scope="request"/>
								<c:set var="field_placeholder" value="Email" scope="request"/>
								<jsp:include page="../form_sections/textfield_contact.jsp"></jsp:include>

                                <c:set var="field_name" value="message" scope="request"/>
								<c:set var="field_label" value="Message" scope="request"/>
								<c:set var="field_placeholder" value="Message" scope="request"/>
								<jsp:include page="../form_sections/textarea_contact.jsp"></jsp:include>

								<c:set var="btn_text" value="Send" scope="request"/>
                                <jsp:include page="../form_sections/button.jsp"></jsp:include>


                            </form:form>

                        </section>





                    </div><!--panel body ends-->

                </div><!--panel panel primary ends-->

            </div><!--col -md-6 ends-->

            <div class="col-md-6">

                <div class="embed-responsive embed-responsive-4by3">
					<address>${map_address}</address>
                </div>

            </div>

        </div><!--col-md-12 ends-->

    </div><!--row ends-->

</div><!--container ends-->

<script type="text/javascript">
     $(document).ready(function(){
        $("address").each(function(){
             var embed = "<iframe width='600' height='450' frameborder='0'"+ 
              "scrolling='no' marginheight='0' marginwidth='0'"+ 
              "src='https://maps.google.com/maps?&amp;q="+ 
              encodeURIComponent( $(this).text() ) +"&amp;output=embed'></iframe>";
             $(this).html(embed);
       });
     });
 </script> 