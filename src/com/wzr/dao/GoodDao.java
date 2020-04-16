package com.wzr.dao;

import com.wzr.entity.Goods;
import com.wzr.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodDao {
    //查询所有用户信息
    public ArrayList<Goods> getAllGoodInfos() {
        DBConn obj = new DBConn();
        Connection connection = obj.getConnection();

        ArrayList<Goods> goods = new ArrayList<>();

        if (connection == null) {
            System.out.println("数据库连接错误");
            return null;
        }

        String sql = "select * from goods";
        try {
            PreparedStatement ptst = connection.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();

            rs.last();
            rs.beforeFirst();

            while (rs.next()){
                Goods good = new Goods();
                good.setGoodsId(rs.getInt("goods_id"));
                good.setGoodsName(rs.getString("goods_name"));
                good.setCostPrice(rs.getInt("cost_price"));
                good.setSellingPrice(rs.getInt("selling_price"));
                good.setManufacturer(rs.getString("manufacturer"));
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL语句有误，数据库报错");
            return null;
        }
        return goods;
    }
}
