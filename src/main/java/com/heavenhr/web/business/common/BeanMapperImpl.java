package com.heavenhr.web.business.common;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class BeanMapperImpl implements BeanMapper
{
    @Autowired
    private Mapper mapper;

    @Override
    public <F, T> T map(F fromBean, Class<T> clazz)
    {
        return fromBean != null ? mapper.map(fromBean, clazz) : null;

    }

    @Override
    public <F, T> List<T> map(List<F> beans, Class<T> clazz)
    {
        List<T> list = new ArrayList<T>();
        for (F bean : beans)
        {
            if (bean != null)
            {
                list.add(mapper.map(bean, clazz));
            }
        }
        return list;
    }

    @Override
    public <F, T> void map(F fromBean, T toBean)
    {
        if ((fromBean != null) && (toBean != null))
        {
            mapper.map(fromBean, toBean);
        }
    }

    @Override
    public <F, T> void map(List<F> fromBeans, List<T> toBeans)
    {
        for (int index = 0; index < fromBeans.size(); index++)
        {
            if (fromBeans.get(index) != null)
            {
                mapper.map(fromBeans.get(index), toBeans.get(index));
            }
        }
    }

    @Override
    public <F, T> T map(F fromBean, Class<T> clazz, String mapId)
    {
        return fromBean != null ? mapper.map(fromBean, clazz, mapId) : null;
    }
}
