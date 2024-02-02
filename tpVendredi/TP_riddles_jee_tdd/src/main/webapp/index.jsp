<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Riddle Answer Result</title>
</head>
<body>
<h1>Riddle Answer Result</h1>
<% boolean answerResult = (boolean) request.getAttribute("answerResult"); %>
<% if (answerResult) { %>
<p>Congratulations! Your answer is correct!</p>
<% } else { %>
<p>Oops! Your answer is incorrect. Please try again.</p>
<% } %>
</body>
</html>
