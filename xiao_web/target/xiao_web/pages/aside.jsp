<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					 class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"></security:authentication>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
					href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
				<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasRole('ADMIN')"></security:authorize>
						<a
							href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/permission/findAll.do">
						<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/sysLog/findAll.do"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
				<span>图书管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/book/findCategory.do">
						<i class="fa fa-circle-o"></i> 图书购入
					</a></li>

					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/book/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 图书信息管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/pages/borrow-page.jsp"> <i
							class="fa fa-circle-o"></i> 借阅/归还图书
					</a></li><li id="system-setting"><a
							href="${pageContext.request.contextPath}/borrow/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 借阅信息
					</a></li>

				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
				<span>会员管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/pages/member-add.jsp">
						<i class="fa fa-circle-o"></i> 新增会员
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/member/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 会员查询
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/pages/shop-add.jsp"> <i
							class="fa fa-circle-o"></i> 添加商家
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/shop/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 商家查询
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/pages/record-add.jsp"> <i
							class="fa fa-circle-o"></i> 刷卡
					</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>