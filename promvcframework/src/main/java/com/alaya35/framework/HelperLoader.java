package com.alaya35.framework;

import com.alaya35.framework.helper.AopHelper;
import com.alaya35.framework.helper.BeanHelper;
import com.alaya35.framework.helper.ClassHelper;
import com.alaya35.framework.helper.ControllerHelper;
import com.alaya35.framework.helper.IocHelper;
import com.alaya35.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author huangyong
 * @since 1.0.0
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
            ClassHelper.class,
            BeanHelper.class,
            AopHelper.class,
            IocHelper.class,
            ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}