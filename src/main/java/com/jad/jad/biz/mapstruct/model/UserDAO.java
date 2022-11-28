package com.jad.jad.biz.mapstruct.model;


import java.util.Date;
import java.util.List;

/**
 * @author nice
 * @create 2022/1/20 10:42 上午
 * @desc
 */
public class UserDAO {

    private int id;

    private String name;

    private Date ctime;

    private Date utime;

    private List<String> toys;

    private String province;

    private String city;

    private String area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public List<String> getToys() {
        return toys;
    }

    public void setToys(List<String> toys) {
        this.toys = toys;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", toys=" + toys +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
