<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@page import="com.px.util.ImportsUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
List<HashMap<String,String>> list=ImportsUtil.readExcel("D:\\百度云\\大数据批量导入\\datawps.xls");
out.print(JSONUtil.serialize(list));
%>


