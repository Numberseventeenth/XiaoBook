<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<table id="dataList"
		   class="table table-bordered table-striped table-hover dataTable">
		<thead>
		<tr>
			<th class="sorting_desc">会员名称</th>
			<th class="sorting_asc sorting_asc_disabled">性别</th>
			<th class="sorting_asc sorting_asc_disabled">学号</th>
			<th class="sorting_desc sorting_desc_disabled">phone</th>
			<th class="sorting">注册时间</th>
			<th class="sorting_desc">系别</th>
			<th class="sorting_desc">班级</th>
			<th class="text-center sorting">备注</th>
			<th class="text-center sorting">状态</th>
			<th class="text-center sorting">等级</th>
			<th class="text-center sorting">积分</th>
		</tr>
		</thead>
		<tbody>


		<c:forEach items="${members}" var="member">

			<tr>
				<input type="text" hidden value="${member.m_id}" name="m_id">
				<td>${member.m_name }</td>
				<td>${member.sexStr }</td>
				<td>${member.m_idcard }</td>
				<td>${member.m_tel }</td>
				<td>${member.dateStr }</td>
				<td class="text-center">${member.m_dept }</td>
				<td class="text-center">${member.m_class }</td>
				<td class="text-center">${member.m_desc }</td>
				<td class="text-center">${member.statusStr}</td>
				<td class="text-center">${member.gradeStr }</td>
				<td class="text-center">${member.m_integral }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
