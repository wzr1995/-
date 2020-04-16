<%@ page import="java.util.List" %>
<%@ page import="com.wzr.entity.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wzr.dao.GoodDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>显示数据库中表的的信息</title>
    <%
      System.out.println("进入首页");
      ArrayList<Goods> goods = new GoodDao().getAllGoodInfos();
      if(goods == null){
        goods = new ArrayList<>();
      }
    %>
  </head>
  <body>
    <table border="1" style="text-align: center;border-collapse:collapse">
      <tr>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>成本价格</th>
        <th>销售价格</th>
        <th>生产商</th>
      </tr>
      <%
        for (Goods good : goods){
      %>
      <tr>
        <td><%=good.getGoodsId()%></td>
        <td><%=good.getGoodsName()%></td>
        <td><%=good.getCostPrice()%></td>
        <td><%=good.getSellingPrice()%></td>
        <td><%=good.getManufacturer()%></td>
      </tr>
      <%
        }
      %>
    </table>
  </body>

</html>
