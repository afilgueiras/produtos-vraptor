<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produto</title>
<script type="text/javascript" src="<c:url value='/js/jquery-1.7.1.min.js'/>"></script>
<script type="text/javascript">
function remover(id) {
    $.get('remove?produto.id=' + id, function() {
        alert('removido com sucesso');
        $('#produto-'+id).remove();
    });
}
</script>
</head>
<body>

<table>
<c:forEach var="produto" items="${produtoList }">
	<tr id="produto-${produto.id}">
		<td>${produto.nome}</td>
		<td>${produto.descricao}</td>
		<td>${produto.cor}</td>
		<td>${produto.preco}</td>
		<td><a href="javascript:void(0);" onclick="remover(${produto.id}); return false;">Remover</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>