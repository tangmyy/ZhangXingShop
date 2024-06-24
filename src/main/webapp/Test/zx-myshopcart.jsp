<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK" language="java"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="GBK">
    <title>���ﳵ</title>
    <link rel="stylesheet" href="zx-myshopcart.css"/>
  </head>
    <body>
    <div class="top">
      <div>
        <c:if test="${empty user}">
          <a href="../login.jsp">�ף����¼</a>
          <a href="../register.jsp">ע��</a>
        </c:if>
        <c:if test="${!empty user}">
          ��ӭ����${user.name} <a href="LoginController?logout">�˳�</a>
        </c:if>
      </div>

      <a  href="HomeController"> ��ҳ </a>
    </div>
    <header>
      <img alt="" src="../image/shopcart/shopCart.png">
      <form action="">
        <input type="search" placeholder="������������">
        <input type="submit" value="����">
      </form>
    </header>
    <c:if test="${empty myShopCartDate.cartList}">
      <h1>���ﳵ�տ���Ҳ���Ͽ�ȥ���</h1>
    </c:if>
    <c:if test="${!empty myShopCartDate.cartList}">
      <main>
        <div class="itemTitle">
          <input  type="checkbox" id="all-checkbox" ${myShopCartDate.allChecked?"checked":""} onclick="updateAllCheckedBox(${itemEntity.value.commodity.id})"/> ȫѡ   <%--id="select-all"--%>
          <img  class="cell cell1" alt="" src="image/empty.png">
          <div class="cell cell3">
            ��Ʒ��Ϣ
          </div>
          <div class="cell cell1">
            ��Ʒ�۸�
          </div>
          <div class="cell cell1">
            ����
          </div>
          <div class="cell cell1">
            ����
          </div>
        </div>

        <c:forEach var="itemEntity" items="${myShopCartDate.cartList}">
          <div class="item">
            <%--class="Alone-checkbox"--%>
            <input class="Alone-checkbox" type="checkbox" data-id="${itemEntity.value.commodity.id}" data-num="${itemEntity.value.num}" onclick="updateByCheckedBox(${itemEntity.value.commodity.id})" ${itemEntity.value.checked?"checked":""}/>
            <img  class="cell" src="${itemEntity.value.commodity.imgpath}"/>
            <div class="cell cell3">${itemEntity.value.commodity.description}</div>
            <div class="cell cell1">${itemEntity.value.commodity.price}</div>
            <div class="cell cell1">
              <button onclick="updateByNum(${itemEntity.value.commodity.id}, -1)">-</button>
              <span>${itemEntity.value.num}</span>
              <button onclick="updateByNum(${itemEntity.value.commodity.id}, 1)">+</button>
            </div>
            <div class="cell cell1">
              <button onclick="remove(${itemEntity.value.commodity.id})">�Ƴ�</button>
            </div>
          </div>
        </c:forEach>
      </main>
    </c:if>
    <div class="total">
      <div class="totalContent">�ܼƣ������˷ѣ���<span>${myShopCartDate.total}</span><button>����</button></div>
    </div>
    <script type="text/javascript" src="../js/home.js"></script>
    <script type="text/javascript" src="../js/mycart.js"></script>
    </body>
</html>