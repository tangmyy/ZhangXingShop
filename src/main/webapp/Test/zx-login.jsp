<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK" language="java"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="GBK">
    <title>��½ҳ��</title>
	<link rel="stylesheet" href="../css/public.css"/>
	<link rel="stylesheet" href="zx-login.css"/>
</head>
<body>
    <div class="box">
        <h2>Log in</h2>
        <form action="LoginController">		<!-- ǰ�治Ҫ��/,��t���ǽ^��·�� -->
	        <div class="input-box">
	            <label>�˺�</label>
	            <input type="text" name="username" id="username" >
	        </div>
	        <div class="input-box">
	            <label>����</label>
	            <input type="password" name="userpwd" id="userpwd" >
	        </div>
			<div class="btn-box">
				<a href="zxretrieve.jsp">��������?</a>
				<div class="button button__around-2">
					<svg>
						<rect height="100%" width="100%"></rect>
					</svg>
					<input type="submit" value="��¼" style="background: transparent; color: inherit; border: none; padding: 0; margin: 0; width: 100%; height: 100%; cursor: pointer;">
				</div>
				<div class="button button__around-2">
					<svg>
						<rect height="100%" width="100%"></rect>
					</svg>
					<a href="zxregister.jsp" style="display: block; width: 100%; height: 100%; color: inherit; text-decoration: none;">
						<span style="display: block; line-height: 35px;">ע��</span>
					</a>
				</div>
			</div>
        </form>
	</div>


    </div>
</body>
</html>