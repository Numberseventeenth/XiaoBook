<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="${pageContext.request.contextPath}/record/save.do" method="post"  target="nm_iframe">
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
			<th class="text-center sorting">备注</th>
			<th class="text-center sorting">状态</th>
			<th class="text-center sorting">等级</th>
			<th class="text-center sorting">积分</th>
			<th class="text-center sorting">选择</th>
			<th class="text-center">操作</th>
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
				<td class="text-center">${member.m_desc }</td>
				<td class="text-center">${member.statusStr}</td>
				<td class="text-center">${member.gradeStr }</td>
				<td class="text-center">${member.m_integral }</td>
				<td class="text-center">
					<select class="form-control select2" style="width: 100%"
							name="shop_id">
						<c:forEach items="${shops}" var="shop">
							<option value="${shop.shop_id}" selected="selected">${shop.shop_name}</option>
						</c:forEach>
					</select>
				</td>
				<td class="text-center">
					<button type="submit" class="btn bg-olive btn-xs">打卡</button>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</form>
<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
