package cn.zn.myblog.service.impl;

import cn.zn.myblog.dao.TypeDao;
import cn.zn.myblog.entity.Type;
import cn.zn.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type saveType(Type type) {
        return null;
    }

    @Override
    public Type getType(Long id) {
        return null;
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return null;
    }

    @Override
    public Type updateType(Long id, Type type) {
        return null;
    }

    @Override
    public void deleteType(Long id) {

    }
}
