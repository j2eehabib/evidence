package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "student", eager = true)
@SessionScoped
public class Student {

    private int id;
    private String username;
    private String password;
    private String mobile;
    private String gender;
    private String[] skill;
    private String courses;
    private String address;
    private Connection conn = null;
    private PreparedStatement pst = null;

    public String store() {
        FacesContext context = FacesContext.getCurrentInstance();
        conn = DBAccess.getConn();
        String sql = "insert into students(id,username,password,mobile,gender,skill,courses,address) "
                + "values(?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareCall(sql);
            pst.setInt(1, id);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, mobile);
            pst.setString(5, gender);
            pst.setString(6, Arrays.toString(skill));
            pst.setString(7, courses);
            pst.setString(8, address);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                context.addMessage(null, new FacesMessage("Save successful"));
                return "index.xhtml";
            } else {
                context.addMessage(null, new FacesMessage("Save failed!"));
                return "index.xhtml";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
