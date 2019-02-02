<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article class="info">
	<figure>
		<img class="info-picture" src="img/noPicture.jpg" />
		<figcaption hidden="true">Profile picture</figcaption>
	</figure>
	<button>Upload Image</button>
	<table>
		<tr>
			<td class="info-title">Name:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.personalInfo.firstName}" /></td>
			<td class="info-title">Email</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.address.email}" /></td>
		</tr>
		<tr>
			<td class="info-title">Surname:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.personalInfo.surname}" /></td>
			<td class="info-title">Street:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.address.streetAddress}" /></td>
		</tr>
		<tr>
			<td class="info-title">Date of Birth:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.personalInfo.dob}" /></td>
			<td class="info-title">City:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.address.city}" /></td>
		</tr>
		<tr>
			<td class="info-title">Phone:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.personalInfo.phoneNumber}" /></td>
			<td class="info-title">Country:</td>
			<td class="info-value"><c:out
					value="${requestScope.bean.address.country}" /></td>
		</tr>
		<tr>
			<td class="info-title"></td>
			<td class="info-value"></td>
			<td class="info-title"></td>
			<td class="info-value"><form action="${param.deleteButton}" method="get">
					<button><c:out value="${param.deleteButton}" /></button>
				</form></td>
		</tr>
	</table>
</article>