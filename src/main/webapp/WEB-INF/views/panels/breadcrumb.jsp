<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${empty home_url}">
		<c:set var="home_url_link" value="/admin/landing" scope="request"/>
	</c:when>
	<c:otherwise>
		<c:set var="home_url_link" value="${home_url}" scope="request"/>
	</c:otherwise>
</c:choose>

<div class="container">   

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">  

            <div class="col-md-9 col-sm-9"> 

                <ul class="breadcrumb">

                    <li class="completed"><a href="<c:url value='${home_url_link}'/>">

                    <i class="fa fa-home"></i>Home</a></li>
					
					<c:forEach var="breadcrumb_item" items="${breadcrumb}">
					     <li class="${breadcrumb_item.value[1]}">
					     	<a href="<c:url value='${breadcrumb_item.value[0]}'/>">${breadcrumb_item.value[2]}</a>
					     </li> 
					</c:forEach>
                </ul>                           

            </div>    

            <div class="col-md-3 col-sm-3 text-right log-out-button">

                <a class="btn-danger" href="<c:url value='/logout'/>"><i class="fa fa-sign-out"></i>Log Out</a>         

            </div>                   

        </div>                    

    </div><!--row ends-->          

</div>