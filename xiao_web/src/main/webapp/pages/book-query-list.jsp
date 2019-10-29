<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<table id="dataList"
		   class="table table-bordered table-striped table-hover dataTable">
		<thead>
		<tr>
			<th>ISBN</th>
			<th>图书名称</th>
			<th>价格</th>
			<th>出版社</th>
			<th>作者</th>
			<th>出版年份</th>
			<th>分类</th>
			<th>库存</th>
			<th>借出</th>
			<th>剩余</th>
		</tr>
		</thead>
		<tbody>


		<c:forEach items="${books}" var="book">

			<tr>
			<tr data-tt-id="0">
				<input type="text" hidden value="${book.book_isbn}" name="book_isbn">
				<td>${book.book_isbn }</td>
				<td>${book.book_name }</td>
				<td>${book.book_price }</td>
				<td>${book.book_public }</td>
				<td>${book.book_author }</td>
				<td class="text-center">${book.book_year }</td>
				<td class="text-center">${book.category.c_name }</td>
				<td class="text-center">${book.book_count }</td>
				<td class="text-center">${book.book_borrow }</td>
				<td class="text-center" style="background-color: yellow">${book.remain }</td>
			</tr>
			</tr>
		</c:forEach>
		</tbody>
	</table>
