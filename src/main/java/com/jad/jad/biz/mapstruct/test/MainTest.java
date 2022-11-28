package com.jad.jad.biz.mapstruct.test;
import com.jad.jad.biz.mapstruct.convert.CommonConvert;
import com.jad.jad.biz.mapstruct.model.AddressDO;
import com.jad.jad.biz.mapstruct.model.UserDAO;
import com.jad.jad.biz.mapstruct.model.UserDO;
import java.util.Date;
import java.util.List;

/**
 * @author nice
 * @create 2022/1/20 1:48 下午
 * @desc
 */
public class MainTest {

    public static void main(String[] args) {
        UserDO userDO = new UserDO();
        userDO.setId(0);
        userDO.setName("李四");
        userDO.setCtime("2021-11-01 10:00:00");
        userDO.setUtime(new Date());
        userDO.setToys(List.of("test", "good"));
        AddressDO addressDO = new AddressDO();
        addressDO.setProvince("北京");
        addressDO.setCity("北京");
        addressDO.setArea("北京");
        userDO.setAddress(addressDO);

        UserDAO userDAO = CommonConvert.INSTANCE.toUserDAO(userDO);
        System.out.println("userDAO = " + userDAO);
    }

    private void daoToDo() {
        UserDAO userDAO = new UserDAO();
        userDAO.setId(1);
        userDAO.setName("历史");
        userDAO.setCtime(new Date());
        userDAO.setUtime(new Date());
        userDAO.setToys(List.of("布娃娃", "擎天柱", "诺曼底"));
        userDAO.setProvince("河南");
        userDAO.setCity("南阳");
        userDAO.setArea("桐柏");

        UserDO userDO = CommonConvert.INSTANCE.toUserDO(userDAO);
        System.out.println("userDO = " + userDO);
    }

}
