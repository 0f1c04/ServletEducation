package com.kosta.model;

import com.kosta.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    public List<ManagerVO> selectAllManager() {
        List<ManagerVO> mlist = new ArrayList<ManagerVO>();
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select employee_id, first_name||last_name fullname " +
                "from EMPLOYEES where employee_id in (select distinct manager_id from employees )";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ManagerVO vo = new ManagerVO(rs.getInt(1), rs.getString(2));
                mlist.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return mlist;
    }

    public List<LocationVO> selectAllLocation() {
        List<LocationVO> loclist = new ArrayList<LocationVO>();
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from LOCATIONS order by 1";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                LocationVO vo = new LocationVO();
                vo.setLocation_id(rs.getInt(1));
                vo.setCity(rs.getString("city"));
                loclist.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return loclist;
    }

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
            conn.setAutoCommit(false);
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

    public int updateDept(DeptVO dept) {
        String sql = "update DEPARTMENTS set DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? " +
                "where DEPARTMENT_ID = ?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;

        int result = 0;

        try {
            st = conn.prepareStatement(sql);
            conn.setAutoCommit(false);

            st.setInt(4, dept.getDept_id());
            st.setString(1, dept.getDept_name());
            st.setInt(2, dept.getManager_id());
            st.setInt(3, dept.getLocation_id());

            result = st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, st, conn);
        }
        return result;
    }

    public int deleteDept(int deptid) {
        String sql = "delete from DEPARTMENTS where DEPARTMENT_ID = ?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;

        int result = 0;

        try {
            st = conn.prepareStatement(sql);
            conn.setAutoCommit(false);

            st.setInt(1, deptid);

            result = st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, st, conn);
        }
        return result;
    }
}
