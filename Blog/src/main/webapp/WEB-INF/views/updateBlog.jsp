<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/updateBlog" method = "post">
<input type ="hidden" name = "blogid" value = "${blog.blogid }">
标题:<input type = "text" name = "title" value = "${blog.title }" /><br/>
<textarea rows="10" cols="40" name = "content">
${blog.content}
</textarea>
<br/>
<input type="submit" name = "修改" />

</form>


</body>
</html>