<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<fieldset class="registration">
		<legend>Personal Data</legend>
		<div>
			<label for="name" class="title">Name</label> <input
				class="input-field" id="name" type="text" name="firstName"
				value="${requestScope.bean.personalInfo.firstName}" />
		</div>
		<div>
			<label for="surname" class="title">Surname</label> <input
				class="input-field" id="surname" type="text" name="surname"
				value="${requestScope.bean.personalInfo.surname}" />
		</div>
		<div>
			<label for="email" class="title">E-mail</label> <input
				class="input-field" id="email" type="email" name="email"
				value="${requestScope.bean.address.email}" />
		</div>
		<div>
			<label for="phoneNumber" class="title">Phone Number</label> <input
				class="input-field" id="phoneNumber" type="text" name="phoneNumber"
				value="${requestScope.bean.personalInfo.phoneNumber}" />
		</div>
		<div>
			<label for="streetAddress" class="title">Street Address</label> <input
				class="input-field" id="streetAddress" type="text"
				name="streetAddress"
				value="${requestScope.bean.address.streetAddress}" />
		</div>
		<div>
			<label for="city" class="title">City</label> <input
				class="input-field" id="city" type="text" name="city"
				value="${requestScope.bean.address.city}" />
		</div>
		<div>
			<label for="country" class="title">Country</label> <input
				class="input-field" id="country" type="text" name="country"
				value="${requestScope.bean.address.country}" />
		</div>
		<div>
			<label for="dob" class="title">Date of Birth</label> <input
				class="input-field" id="dob" type="date" name="dob"
				value="${requestScope.bean.personalInfo.dob}" />
		</div>
		<div>
			<input type="submit" id="submit" value="Done" />
		</div>
	</fieldset>
</article>