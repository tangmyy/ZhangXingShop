<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK" language="java"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>ע��ҳ��</title>
    <link rel="stylesheet" href="../css/public.css">
    <link rel="stylesheet" href="zx-register.css"/>

</head>
<body>
<div class="box">
    <h2>Sign in</h2>
    <form action="RegisterController" onsubmit="return Check();" >		<!-- ǰ�治Ҫ��/,��t���ǽ^��·�� -->
        <div class="input-box">
            <label>�˺�</label>
            <input type="text" name="rs_username" id="rs_username" placeholder="�˺�" required>
        </div>
        <div class="input-box">
            <label>����</label>
            <input type="password" name="rs_userpwd" id="rs_userpwd" placeholder="����" required>
        </div>
        <div class="input-box">
            <label>ȷ������</label>
            <input type="password" name="rs_qruserpwd" id="rs_qruserpwd" placeholder="ȷ������" required>
        </div>
        <div class="input-box">
            <label>�绰����</label>
            <input type="text" name="rs_tel" id="rs_tel" placeholder="�绰����" required>
        </div>
        <div class="input-box">
            <label>�����</label>
            <input type="text" name="rs_email" id="rs_email" placeholder="�����" required>
        </div>
        <div class="input-box">
            <label>�Ա�</label>
            <input type="text" name="rs_sex" id="rs_sex" placeholder="�Ա�" required>
        </div>
        <div class="btn-box">
            <div>
                <input type="submit" onclick="" value="ע��">
            </div>
        </div>
    </form>
</div>

<script type="text/javascript" src="../js/register.js"></script>

</body>
</html>