<%--
  Created by IntelliJ IDEA.
  User: TaoTao
  Date: 2024/6/17
  Time: ����2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK" language="java"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="GBK">
    <title>�һ�����</title>
    <link rel="stylesheet" href="../css/public.css"/>
    <link rel="stylesheet" href="zx-retrieve.css"/>
</head>

<body>
    <div class="box">
    <h2>Retrieve</h2>

    <form action="RetrieveController" onsubmit="return passwordCheck();" >		<!-- ǰ�治Ҫ��/,��t���ǽ^��·�� -->
        <div class="input-box">
            <label>�˺�</label>
            <input type="text" name="Ret_username" id="Ret_username" placeholder="�˺�" required>
        </div>
        <div class="input-box">
            <label>������</label>
            <input type="password" name="Ret_userpwd" id="Ret_userpwd" placeholder="������" required>
        </div>
        <div class="input-box">
            <label>ȷ������</label>
            <input type="password" name="Ret_qruserpwd" id="Ret_qruserpwd" placeholder="ȷ������" required>
        </div>
        <input type="hidden" id="oldPwdMD5Check" name="oldPwdMD5Check">
        <div class="btn-box">
            <a href="zxlogin.jsp"> [��¼ҳ��] </a>
            <div>
                <input type="submit" onclick="" value="�һ�����">
            </div>
        </div>
    </form>
    </div>
</body>

<script type="text/javascript" src="../js/retrieve.js"></script>
</html>
