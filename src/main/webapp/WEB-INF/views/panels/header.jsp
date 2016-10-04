<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header> 

    <div class="container">       

        <div class="row">           

            <div class="col-md-9">     
				<a href="<c:url value='/login'/>">
                	<img src="<c:url value="/resources/images/logo.png" />" class="img-responsive" alt="logo" />   
				</a>
            </div>  
            <div class="col-md-3">
				<c:set var="titleKey">
			        <tiles:insertAttribute name="title" ignore="true" />
			    </c:set>
				<c:if test="${not empty titleKey}">
	            	<div id="page_title_in_page">
	            		<tiles:insertAttribute name="title" ignore="true" />
	            	</div>
				</c:if>
            </div>                  

        </div>

    </div>

</header>

<!--header ends-->