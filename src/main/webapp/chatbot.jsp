<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Cleverest AI Chatbot</title>
<style type="text/css">
body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 600px;
	margin: 0 auto;
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

button {
	background-color: #3babd4;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #136f91;
}

p {
	margin-bottom: 15px;
	padding: 10px;
	border-radius: 5px;
	width: auto
}

.query {
	background-color: #dbceb8;
	text-align: right;
}

.response {
	background-color: #b1cacc;
	text-align: left;
}

form {
	display: flex;
	gap: 10px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="response">
			<p>Hi, what can I help with?</p>
		</div>

		<c:forEach var="conversation" items="${allCon}">
			<div class="query">
				<p>${conversation.userQuery}</p>
			</div>

			<div class="response">
				<p>${conversation.chatbotResponse}</p>
			</div>
		</c:forEach>

		<form action="question" method="post">
			<label>Question</label> <input type="text" name="question" />
			<button type="submit">Submit</button>
		</form>
	</div>

</body>
</html>