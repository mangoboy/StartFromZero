package com.gsl.common.utils;

import com.gsl.common.dto.PageDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author taojirun
 * @description 分页工具类
 * @date 16:46 2023/5/16
 **/
public class PageUtil {

    /**
     * @param dto
     * @return com.github.pagehelper.Page
     * @description 开始分页
     * @author taojirun
     * @date 17:01 2023/5/16
     **/
    public static Page startPage(PageDTO dto) {
        return PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
    }

    /**
     * @param entityList 数据库对象
     * @param voList     视图对象
     * @return com.github.pagehelper.PageInfo<T>
     * @description 获取分页结果
     * @author taojirun
     * @date 17:02 2023/5/16
     **/
    public static <T> PageInfo<T> page(List entityList, List<T> voList) {
        PageInfo pageInfo = new PageInfo<>(entityList);
        if (!CollectionUtils.isEmpty(voList)) {
            pageInfo.setList(voList);
        }
        return pageInfo;
    }


}
