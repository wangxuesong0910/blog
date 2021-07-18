package com.bubudeai.utils;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;

/**
 * 单例模式返回分页
 */
public class PageUtils {
    public PageUtils() {
    }
    public  static PageRowBounds getPageRowBounds(int offset, int limit){
        return new PageRowBounds(offset,limit);
    }
}
