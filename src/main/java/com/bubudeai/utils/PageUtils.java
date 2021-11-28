package com.bubudeai.utils;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;

/**
 * 逻辑分页：数据量大的时候压力较大
 *  因为逻辑分页一次性查出所有需要分页的数存放在内存中，
 *  当数据过大会占用大量内存，同时查询的用时会相较于物理分页更久
 */
public class PageUtils {
    private PageUtils() {}
    public  static PageRowBounds getPageRowBounds(int offset, int limit){
        return new PageRowBounds(offset,limit);
    }
}
