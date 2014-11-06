<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.lang.Math,org.sonatype.mavenbook.utils.Page" %> 
<%@ taglib prefix="mx" tagdir="/WEB-INF/tags" %>
<html>

	<head>
		<title>Spring MVC Starter Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/screen.css"/>"/>
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/list">
		<%-- value="${param.search_LIKE_title} --%>
			<input id="search_zip" name="search_zip" type="text">
			<input type="submit" value="search">
		</form>
	
	
		<div id="container">
			<table class="simpletablestyle">
				<thead>
					<tr>
						<th>ZIP</th>
						<th>CITY</th>
						<th>COUNTRY</th>
						<th>REGION</th>
						<th>REST URL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${locations}" var="loc">
						<tr>
							<td>${loc.zip}</td>
							<td>${loc.city}</td>
							<td>${loc.country}</td>
							<td>${loc.region}</td>
							<td><a href="<c:url value="/rest/members/${member.id}"/>">/rest/members/${member.id}</a></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		${pageContext.request.contextPath}
		<%-- 
		<%
			Page pagerz=(Page) pageContext.getAttribute("pager");
			//Page pagez = null;
			if(pageContext.getAttribute("pager")==null){
				pagerz = Page.newBuilder(1, 2, "list");
				out.println(Math.random());
			}
			String asdd ="hi!";
		%> 
		 zz ${pager.pageNo} oo ${asdd} 
		--%>
		<mx:page pager="${pager}"/> 
		<%-- <c:if test="${empty pager}">  
		<mx:page pager="<%=pagerz%>"/> 
		    <c:set var="pagerzz" value="<%=asdd%>"/>  
		</c:if>  
		${param['pager']}     
		${pagerzz} --%>
	</body>
</html>
