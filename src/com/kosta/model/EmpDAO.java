package com.kosta.model;

import com.kosta.util.ConvertUtil;
import com.kosta.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO : Data Access Object
public class EmpDAO {

    //CRUD(Create:insert, Read:select, U:update, D:delete)
    //    ڰ
    public int deleteEmp(int empid) {
        int result = 0;
        String sql = "delete from employees"
                + " where EMPLOYEE_ID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empid);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, ps, conn);
        }
        return result;
    }
    //    ڰ                        ,                 => controller => DAO => DB
    public int updateEmp(EmpVO emp) {
        int result = 0;
        String sql = "update employees set "
                + " FIRST_NAME = ?,"
                + " LAST_NAME = ?,"
                + " EMAIL = ?,"
                + " PHONE_NUMBER = ?,"
                + " HIRE_DATE = ?,"
                + " JOB_ID = ?,"
                + " SALARY = ?,"
                + " COMMISSION_PCT = ?,"
                + " MANAGER_ID = ?,"
                + " DEPARTMENT_ID = ?"
                + " where EMPLOYEE_ID = ?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = DBUtil.getConnection();
        try {
            st = conn.prepareStatement(sql);
            st.setInt(11, emp.getEmployee_id());
            st.setString(1, emp.getFirst_name());
            st.setString(2, emp.getLast_name());
            st.setString(3, emp.getEmail());
            st.setString(4, emp.getPhone_number());
            st.setDate(5, emp.getHire_date());
            st.setString(6, emp.getJob_id());
            st.setInt(7, emp.getSalary());
            st.setDouble(8, emp.getCommission_pct());
            if(emp.getManager_id()==0) st.setNull(9, Types.INTEGER);
            else st.setInt(9, emp.getManager_id());
            st.setInt(10, emp.getDepartment_id());
            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, st, conn);
        }

        return result;
    }

    //    ڰ          ؼ  ȸ       => controller => service => DAO
    public int insertEmp(EmpVO emp) {
        String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn;
        PreparedStatement st = null;
        int result = 0;

        conn = DBUtil.getConnection();
        try {
            conn.setAutoCommit(false); // ѹ         SQL          ϰ     ϴ
            st = conn.prepareStatement(sql);
            st.setInt(1, emp.getEmployee_id());
            st.setString(2, emp.getFirst_name());
            st.setString(3, emp.getLast_name());
            st.setString(4, emp.getEmail());
            st.setString(5, emp.getPhone_number());
            st.setDate(6, emp.getHire_date());
            st.setString(7, emp.getJob_id());
            st.setInt(8, emp.getSalary());
            st.setDouble(9, emp.getCommission_pct());
            st.setInt(10, emp.getManager_id());
            st.setInt(11, emp.getDepartment_id());
            result = st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, st, conn);
        }
        return result;
    }

    //1.            ȸ
    public List<EmpVO> selectAll() {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from employees";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return emplist;
    }

    //2.  ⺻Ű (Primary key) : null  Ұ ,  ʼ Į  ,  ߺ
    //      ȣ     ȸ
    public EmpVO selectById(int empid) {
        EmpVO emp = null;
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where employee_id = ?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, empid);
            rs = st.executeQuery();
            while(rs.next()) {
                emp = makeEmp(rs);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return emp;
    }

    //3.  μ      ȸ
    public List<EmpVO> selectByDept(int deptid) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where department_id = ?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, deptid);
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    //4. job_id     ȸ
    public List<EmpVO> selectByJobId(String jobid) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where job_id = ?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, jobid);
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    //5.  ޿      ȸ
    public List<EmpVO> selectBySalary(int minSalary, int maxSalary) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where salary between ? and ?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, minSalary);
            st.setInt(2, maxSalary);
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    //6-1.  Ի  Ϸ    ȸ(1) String
    public List<EmpVO> selectByHireString(String hire) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where hire_date >= ?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, hire);
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    //6-2.  Ի  Ϸ    ȸ(2) Date
    public List<EmpVO> selectByHireDate(Date sDate, Date eDate) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where hire_date between ? and ?";
        try {
            st = conn.prepareStatement(sql);
            st.setDate(1, sDate);
            st.setDate(2, eDate);
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    //7.  ̸    Ư     ڰ           ȸ
    public List<EmpVO> selectByName(String name) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where first_name like ?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    //8.            ȸ( μ , job, salary, hire_date)
    public List<EmpVO> selectByMix(String dept, String jobId, int salary, Date hireDate) {
        List<EmpVO> emplist = new ArrayList<EmpVO>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from employees where department_id = ? and job_id = ? and salary >= ? and hire_date between ? and add_months(?,24)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, dept);
            st.setString(2, jobId);
            st.setInt(3, salary);
            st.setDate(4, hireDate);
            st.setDate(5, hireDate);
            rs = st.executeQuery();
            while(rs.next()) {
                emplist.add(makeEmp(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }
        return emplist;
    }

    private EmpVO makeEmp(ResultSet rs) throws SQLException {
        EmpVO emp = new EmpVO();
        emp.setCommission_pct(rs.getDouble("commission_pct"));
        emp.setDepartment_id(rs.getInt("department_id"));
        emp.setEmail(rs.getString("email"));
        emp.setEmployee_id(rs.getInt("employee_id"));
        emp.setFirst_name(rs.getString("first_name"));
        emp.setHire_date(ConvertUtil.convertDate(rs.getString("hire_date")));
        emp.setJob_id(rs.getString("job_id"));
        emp.setLast_name(rs.getString("last_name"));
        emp.setManager_id(rs.getInt("manager_id"));
        emp.setPhone_number(rs.getString("phone_number"));
        emp.setSalary(rs.getInt("salary"));
        return emp;
    }

    public Object selectAllJobID() {
        List<JobVO> joblist = new ArrayList<JobVO>();
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from JOBS order by 1";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                JobVO vo = new JobVO();
                vo.setJob_id(rs.getString(1));
                vo.setJob_title(rs.getString("job_title"));
                joblist.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return joblist;
    }

    public Object selectAllManagerID() {
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

    public Object selectAllDepartmentID() {
        List<DepartmentVO> deptlist = new ArrayList<DepartmentVO>();
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from DEPARTMENTS order by 1";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DepartmentVO vo = new DepartmentVO();
                vo.setDepartment_id(rs.getInt(1));
                vo.setDepartment_name(rs.getString("department_name"));
                deptlist.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return deptlist;
    }
}