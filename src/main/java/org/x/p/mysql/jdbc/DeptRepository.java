package org.x.p.mysql.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeptRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 原来的JDBC
     *
     * @return
     * @throws SQLException
     */
    public List<Dept> findAll() throws SQLException {

        String sql = "select * from dept";
        Connection conn = DriverManager.getConnection("");
        Statement stat = conn.createStatement();
        stat.execute(sql);
//		查询获得结果集
        ResultSet rs = stat.executeQuery("");

        List<Dept> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String loc = rs.getString("loc");

            Dept dept = new Dept();
            dept.id = id;
            dept.title = title;
            dept.loc = loc;
            list.add(dept);
        }

//		关闭连接
        rs.close();
        stat.close();
        conn.close();

        return list;
    }


    //	结果集记录的一行,映射特定的对象
    RowMapper<Dept> mapper = new RowMapper<Dept>() {

        @Override
        public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dept dept = new Dept();
            dept.setId(rs.getInt("id"));
            dept.setTitle(rs.getString("title"));
            dept.setLoc(rs.getString("loc"));
            return dept;
        }
    };


    /**
     * 2001
     * 封装了JDBC,觉得JDBC太繁琐
     * jdbcTemplate
     *
     * @return Dept对象构成的列表/结果集记录行
     */

    public List<Dept> findALL() {

        return jdbcTemplate.query("select * from dept", mapper);
    }

    /**
     * jdbcTemplate
     *
     * @param loc
     * @return
     */
    public List<Dept> findByLoc(String loc) {

//		sql语句
        String sql = "select * from dept where loc like ?";

//		参数
        Object[] args = {"%" + loc + "%"};
//		执行查询
        return jdbcTemplate.query(sql, args, mapper);
    }


    public void remove(int id) {

        String sql = "delete "
                + "from dept "
                + "where id=? "
                + "and "
                + "loc=? ";
        jdbcTemplate.execute(sql);
    }
}
