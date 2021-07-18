package com.bubudeai.service.impl;

import com.bubudeai.entity.Group;
import com.bubudeai.mapper.GroupMapper;
import com.bubudeai.service.GroupService;
import com.bubudeai.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Transactional
    @Override
    public int addGroup(String gname) {
        //判断传递的gname是否为null值，不为空则执行
        if (gname!=null){
            Group group = new Group();
            group.setGname(gname);
            group.setCreated(DateUtils.getTime());
            int i = groupMapper.addGroup(group);
            return i;
        }
        return 0;
    }

    @Override
    public List<Group> queryAllGroup() {
        List<Group> groups = groupMapper.queryAllGroup();
        return groups;
    }

    @Transactional
    @Override
    public int deleteGroup(int gid) {
       int i =  groupMapper.deleteGroup(gid);
        return i;
    }
}
