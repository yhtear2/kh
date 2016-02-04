<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${result}
<c:if test="${result == 0}">
	<script type="text/javascript">
		alert("비번 확인");
		history.back();
	</script>
</c:if>
<c:if test="${result == 1}">
	<form method="post" name="form" action="compInputPro.do">
		<table border="1">
			<tr>
				<th> 회사 대표 </th>
				<td> <input type="text" name="ceo"> </td>
				<th> 설립일 </th>
				<td> <input type="text" name="comp_reg_date"> </td>
				<th> 기업 형태 </th>
				<td> <input type="text" name="comp_type"> </td>
				
			</tr>
			<tr>
				<th> 전화 번호</th>
				<td colspan="5">
					<input type="text" name="tel1">
					- <input type="text" name="tel2">
					- <input type="text" name="tel3">
				</td>
			</tr>
			<tr>
				<th rowspan="2"> 주소 </th>
				<td colspan="5"> <input type="text" name="zipcode1"> - <input type="text" name="zipcode2"> </td>
			</tr>
			<tr>
				<td colspan="5"> <input type="text" name="address1"> - <input type="text" name="address2"> </td>
			</tr>
			
			<tr>
				<th> 자본금 </th>
				<td> <input type="text" name="capital"> </td>
				<th> 연매출 </th>
				<td> <input type="text" name="year_sale"> </td>
				<th> 사원수 </th>
				<td> <input type="text" name="emp_count"> </td>
			</tr>
			<tr>
				<th colspan="6">
					<input type="submit" value="submit">
					<input type="reset" value="reset">
				</th>
			</tr>
		</table>
	</form>
</c:if>













