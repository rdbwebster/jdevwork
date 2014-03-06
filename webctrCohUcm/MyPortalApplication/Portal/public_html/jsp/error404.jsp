<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <fmt:bundle basename="oracle.webcenter.portalframework.sitestructure.resource.PortalAppPageResource">
      <title><fmt:message key="error_title"/> 404</title>
    </fmt:bundle>   
  </head>    
  <body>
    <c:set var="authenticated" scope="request"
           value="${securityContext.authenticated}"/>
    <%
    Boolean isAuthenticated = (Boolean)request.getAttribute("authenticated");
    if (isAuthenticated == null || !isAuthenticated.booleanValue())
      response.sendRedirect(request.getContextPath() + "/adfAuthentication?success_url=/faces" + request.getServletPath());
    else
      response.sendError(404);
    %>
  </body>
</html>