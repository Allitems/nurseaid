<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="container">

    <div class="row">

        <div class="col-md-12 col-sm-12 no_padding">

            <div class="col-md-4 col-sm-4">

                <form action="<c:url value='/admin/employer/search'/>" class="employee-search employee-search-panel" method="post">

                    <div class="input-group">

                        <div class="input-group-btn search-panel">

                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>

                        </div>

                        <input type="hidden" name="search_param" value="name">		 

                        <input type="text" class="form-control" value="${q}" name="q" placeholder="employer name or id">

                        <span class="input-group-btn">

                            <button class="btn btn-primary" type="submit">  Search  </button>

                        </span>

                    </div>

                </form>

            </div>

            <div class="col-md-6 col-sm-6"></div>

        </div><!--col-md-12 ends-->

    </div><!--row ends-->

</div><!--container ends-->