<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == 0}">
	기업 정보 입력 실패
</c:if>

<c:if test="${result == 1}">
	기업 정보 입력 성공
</c:if>




