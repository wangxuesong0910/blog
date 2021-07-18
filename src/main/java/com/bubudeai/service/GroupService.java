package com.bubudeai.service;

import com.bubudeai.entity.Group;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface GroupService {
    int addGroup(String gname);
    List<Group> queryAllGroup();
    int deleteGroup(int index);
}
