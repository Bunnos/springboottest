package com.boot.service.imp;

import com.boot.dao.cluster.JsUserMapper;
import com.boot.dao.master.BokaMembersMapper;
import com.boot.model.cluster.JsUser;
import com.boot.model.master.BokaMembers;
import com.boot.model.master.BokaMembersExample;
import com.boot.service.UserService;
import com.boot.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/6.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private BokaMembersMapper membersMapper;
    @Autowired
    private JsUserMapper userMapper;
    @Override
    public String transportUserInfo() {
        BokaMembersExample membersExample = new BokaMembersExample();
        membersExample.createCriteria().andUidIsNotNull();
        List<BokaMembers> bokaMembers = membersMapper.selectByExample(membersExample);
        if(bokaMembers!=null && bokaMembers.size()>0){
            JsUser jsUser;
            for (BokaMembers entity: bokaMembers){
//            for (int i =0;i<2;i++){
//                BokaMembers entity = bokaMembers.get(i);
                jsUser = new JsUser();
                jsUser.setId(UUID.randomUUID().toString());
                jsUser.setUsername(entity.getUsername());
                jsUser.setPassword(entity.getPassword());
                jsUser.setEmail(entity.getEmail());
                jsUser.setWorkplace(entity.getAddress());
                jsUser.setMobile(entity.getMobile());
                jsUser.setSex(entity.getSex());
                jsUser.setState("0");// 0 正常 1 禁止
                jsUser.setType("0");// 0 普通 1 专家
                jsUser.setRegisterdate(DateUtils.timeStampToDate(entity.getRegdate()));
                userMapper.insert(jsUser);
            }
        }
        return "success";
    }
}
