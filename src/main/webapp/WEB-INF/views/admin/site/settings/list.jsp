<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../../../panels/message.jsp"></jsp:include>


<div class="container">

     <div class="row">

         <div class="col-md-12">

             <div class="panel panel-primary">
             	
                 <table id="nurse-table" class="table-responsive table table-bordered table-striped table-hover">

                     <thead>

                     <th>KEY</th>

                     <th>VALUE</th>
                     
                     <th>Action</th>

                     </thead>

                     <tbody>
	                     <c:choose>
						      <c:when test="${not empty list}">
						      		<c:forEach var="item" items="${list}">
										<tr>
				                             <td>${item.getTitle()}</td>	
				                             <c:choose>
												<c:when test="${item.getType() eq 'file'}">
													<td>
															<c:choose>
																<c:when test="${item.getValue() eq ''}">
																	NO FILE UPLOADED
																</c:when>
																<c:otherwise>
																	<a target="_blank" href="${DIR_PATH}${item.getValue()}">
										                             	${item.getValue()}
										                             </a>
																</c:otherwise>
															</c:choose>
						                             </td>
												</c:when>
												<c:otherwise>
													<td>
						                             	${item.getValue()}
						                            </td>
												</c:otherwise>
											</c:choose>			
				                             				
				                             <td>
				                             	<a href="<c:url value='/admin/site/settings/edit/${item.getId()}'/>" class="btn btn-info">Edit</a>
				                             </td>
				
				                         </tr>
									</c:forEach>
						      </c:when>
						      <c:otherwise>
						      		<tr>
			                             <td colspan="3">No Results to Display</td>
				                    </tr>
						      </c:otherwise>
					   	 </c:choose>                      

                     </tbody>

                 </table>

             </div>

         </div>

     </div>

 </div>
