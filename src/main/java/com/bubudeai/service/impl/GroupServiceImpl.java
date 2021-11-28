package com.bubudeai.service.impl;

import com.bubudeai.dto.DeleteGroupDto;
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
    @Transactional(rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public int addGroup(Group group) {
        //判断传递的gname是否为null值，不为空则执行

        int i = groupMapper.addGroup(group);
        return i;
    }

    @Override
    public List<Group> queryAllGroup() {
        List<Group> groups = groupMapper.queryAllGroup();
        return groups;
    }

    @Transactional(rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public int deleteGroup(int gid) {
        /**
         * 判断当前技术分类下是否还有文章，因为contents 表中
         * gid为外键，删除技术分类需要确保，
         * 技术分类下的文章已被全部删除
         */
        int i =0;
        List<DeleteGroupDto> deleteGroupDtos = groupMapper.queryContentByGroupID(gid);
        if (deleteGroupDtos.isEmpty()){
         i =  groupMapper.deleteGroup(gid);

         return i;
        }
        return i;
    }

    @Override
    public Group queryGroupForUpdate(int gid) {
        Group group = groupMapper.queryGroupForUpdate(gid);
        return group;
    }

    @Transactional(rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public int updateGroup(Group group) {
        int i = groupMapper.updateGroup(group);
        return i;
    }
}
