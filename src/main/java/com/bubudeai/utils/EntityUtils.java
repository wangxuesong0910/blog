package com.bubudeai.utils;

import com.bubudeai.entity.Contents;
import com.bubudeai.entity.Group;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/23/13:53
 * @Description:
 **/
public class EntityUtils {
    private static Contents contents = null;
    private static Group group = null;

    private EntityUtils() {
    }

    public static Contents getContents(){
        if (contents == null){
            return new Contents();
        }
        return contents;
    }

    public static Group getGroup(){
        if (group == null){
            return new Group();
        }
        return group;
    }
}
