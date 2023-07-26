package com.gsl.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法类用来拷贝转化对象
 *
 * @author taojirun
 */
@Slf4j
public class EntityUtil {

    private EntityUtil() {

    }

    /**
     * 实体转换
     *
     * @param source           源对象
     * @param targetClass      目标对象的Class类型
     * @param ignoreProperties
     * @return
     */
    public static <S, T> T transform(S source, Class<? extends T> targetClass, String... ignoreProperties) {
        if (source != null) {
            T target = null;
            try {
                target = targetClass.newInstance();
                BeanUtils.copyProperties(source, target, ignoreProperties);
            } catch (Exception e) {
                log.error("实体转换出错", e);
                return null;
            }
            return target;
        } else {
            return null;
        }
    }

    public static <S, T> T transform(S source, Class<? extends T> targetClass) {
        return transform(source, targetClass, null);
    }


    /**
     * 实体列表转换
     *
     * @param sourceList
     * @param targetClass
     * @return
     */
    public static <S, T> List<T> transformList(List<S> sourceList, Class<? extends T> targetClass, String... ignoreProperties) {
        List<T> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sourceList)) {
            for (S source : sourceList) {
                result.add(transform(source, targetClass, ignoreProperties));
            }
        }
        return result;
    }

    public static <S, T> List<T> transformList(List<S> sourceList, Class<? extends T> targetClass) {
        return transformList(sourceList, targetClass, null);
    }


}