package com.kosta.model;

import com.kosta.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    public List<DeptVO> selectAll() {
        List<DeptVO> deptlist = new ArrayList<DeptVO>();
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from departments";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DeptVO dept = new DeptVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                deptlist.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return deptlist;
    }

    public int insertDept(DeptVO dept) {
        String sql = "insert into departments values(?, ?, ?, ?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        int result = 0;

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, dept.getDept_id());
            st.setString(2, dept.getDept_name());
            st.setInt(3, dept.getManager_id());
            st.setInt(4, dept.getLocation_id());

            result = st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, st, conn);
        }
        return result;
    }

    public DeptVO selectById(int i_deptid) {
        DeptVO dept = null;
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from departments where DEPARTMENT_ID = ?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, i_deptid);
            rs = st.executeQuery();
            while (rs.next()) {
                dept = new DeptVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return dept;
    }

}
