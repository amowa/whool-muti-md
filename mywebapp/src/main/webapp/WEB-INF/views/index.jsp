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
		<div id="container">
			<div class="dualbrand">
				<img src="<c:url value="/static/resources/gfx/dualbrand_logo.png"/>"/>
			</div>
			<div id="content">
				<h1>Welcome to JBoss!</h1>

				<div>
					<p>You have successfully deployed a Spring MVC web application.</p>
					<h3>Your application can run on:</h3>
					<img src="<c:url value="/static/resources/gfx/dualbrand_as7eap.png"/>"/>
				</div>
				
				<form:form commandName="newMember" id="reg">
					<h2>Member Registration</h2>
					<p>Enforces annotation-based constraints defined on the model class.</p>
					<table>
						<tbody>
							<tr>
								<td><form:label path="zip">zip:</form:label></td>
								<td><form:input path="zip"/></td>
								<td><form:errors class="invalid" path="zip"/></td>
							</tr>
							<tr>
								<td><form:label path="city">city:</form:label></td>
								<td><form:input path="city"/></td>
								<td><form:errors class="invalid" path="city"/></td>
							</tr>
							<tr>
								<td><form:label path="country">country:</form:label>
								<td><form:input path="country"/></td>
								<td><form:errors class="invalid" path="country"/></td>
							</tr>
							<tr>
								<td><form:label path="region">region:</form:label>
								<td><form:input path="region"/></td>
								<td><form:errors class="invalid" path="region"/></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="Register" class="register"/>
							</td>
						</tr>
					</table>
				</form:form>
				
				<%-- <form:form commandName="newMember" id="reg">
					<h2>Member Registration</h2>
					<p>Enforces annotation-based constraints defined on the model class.</p>
					<table>
						<tbody>
							<tr>
								<td><form:label path="name">Name:</form:label></td>
								<td><form:input path="name"/></td>
								<td><form:errors class="invalid" path="name"/></td>
							</tr>
							<tr>
								<td><form:label path="email">Email:</form:label></td>
								<td><form:input path="email"/></td>
								<td><form:errors class="invalid" path="email"/></td>
							</tr>
							<tr>
								<td><form:label path="phoneNumber">Phone #:</form:label>
								<td><form:input path="phoneNumber"/></td>
								<td><form:errors class="invalid" path="phoneNumber"/></td>
							</tr>
	
						</tbody>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="Register" class="register"/>
							</td>
						</tr>
					</table>
				</form:form> --%>
				<%-- <h2>Members</h2>
				<c:choose>
					<c:when test="${members.size()==0}">
						<em>No registered members.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Email</th>
									<th>Phone #</th>
									<th>REST URL</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${members}" var="member">
									<tr>
										<td>${member.id}</td>
										<td>${member.name}</td>
										<td>${member.email}</td>
										<td>${member.phoneNumber}</td>
										<td><a href="<c:url value="/rest/members/${member.id}"/>">/rest/members/${member.id}</a></td>
								</c:forEach>
							</tbody>
						</table>
						<table class="simpletablestyle">
							<tr>
								<td>
									REST URL for all members: <a href="<c:url value="/rest/members"/>">/rest/members</a>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose> --%>
			</div>
			<div id="aside">
				<p>Learn more about JBoss Enterprise Application Platform 6.</p>
				<ul>
					<li><a
						href="http://red.ht/jbeap-6-docs">Documentation</a></li>
					<li><a href="http://red.ht/jbeap-6">Product Information</a></li>
				</ul>
				<p>Learn more about JBoss AS 7.</p>
				<ul>
					<li><a
						href="https://docs.jboss.org/author/display/AS7/Getting+Started+Developing+Applications+Guide">Getting Started Developing Applications Guide</a></li>
					<li><a href="http://jboss.org/jbossas">Community Project Information</a></li>
				</ul>
			</div>
			<div id="footer">
			    <p>
					This project was generated from a Maven archetype from
			        	JBoss.<br />
			    </p>
			</div>
		</div>
		
		<%
			Page pagerz=(Page) pageContext.getAttribute("pager");
			//Page pagez = null;
			if(pageContext.getAttribute("pager")==null){
				pagerz = Page.newBuilder(1, 2, "/");
				out.println(Math.random());
			}
			String asdd ="hi!";
		%> 
		 zz ${pageScope.pager.pageNo} oo ${pageScope.asdd} 
		 
		<mx:page pager="<%=pagerz%>"/> 
		<%-- <c:if test="${empty pager}">  
		    <c:set var="pagerzz" value="<%=asdd%>"/>  
		</c:if>   
		${pagerzz} --%>
	</body>
</html>
