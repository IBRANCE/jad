package com.jad.jad.biz.mapstruct.model;


import java.util.Date;
import java.util.List;

/**
 * @author nice
 * @create 2022/1/20 10:42 上午
 * @desc
 */
public class UserVO {

    private Integer id;

    private String name;

    private Date ctime;

    private Date utime;

    private List<String> toys;

    private AddressVO address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public AddressVO getAddress() {
        return address;
    }

    public void setAddress(AddressVO address) {
        this.address = address;
    }
}
