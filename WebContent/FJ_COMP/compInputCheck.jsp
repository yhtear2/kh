<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form method="post" name="form" action="compInputForm.do">
	<table>
		<tr>
			<th> 비밀번호 </th>
			<td> <input type="password"> </td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="submit">
				<input type="button" value="cancel" onclick="history.back()">
			</th>
		</tr>
	</table>
</form>






