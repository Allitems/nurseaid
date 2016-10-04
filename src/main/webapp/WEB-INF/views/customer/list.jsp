<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<h1>${fx}</h1>
<c:forEach var="user" items="${data_list}">
     <h3>${user.getUserName()}</h3>   
</c:forEach>

<input type="button" value="click me" onclick="showBox();" />