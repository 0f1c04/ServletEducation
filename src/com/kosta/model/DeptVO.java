package com.kosta.model;

public class DeptVO {
    int dept_id;
    String dept_name;
    int manager_id;
    int location_id;

    public DeptVO() {}

    public DeptVO(int dept_id, String dept_name, int manager_id, int location_id) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.manager_id = manager_id;
        this.location_id = location_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeptVO{");
        sb.append("dept_id=").append(dept_id);
        sb.append(", dept_name='").append(dept_name).append('\'');
        sb.append(", manager_id=").append(manager_id);
        sb.append(", location_id=").append(location_id);
        sb.append('}');
        return sb.toString();
    }
}
