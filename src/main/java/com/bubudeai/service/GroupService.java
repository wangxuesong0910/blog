package com.bubudeai.service;

import com.bubudeai.entity.Group;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface GroupService {
    int addGroup(Group group);
    List<Group> queryAllGroup();
    int deleteGroup(int index);
    Group queryGroupForUpdate(int gid);
    int updateGroup(Group group);
}
