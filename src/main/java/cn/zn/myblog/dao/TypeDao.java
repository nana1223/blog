package cn.zn.myblog.dao;

import cn.zn.myblog.entity.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TypeDao {

    @Insert("insert into t_type values(#{id}, #{name})")
    Type saveType(Type type);

    @Select("select *from t_type where id=#{id}")
    Type getType(Long id);

    //分页查询？？？
    Page<Type> listType(Pageable pageable);

    @Update("update t_type set name=#{name} where id=#{id}")
    Type updateType(Type type);

    @Delete("delete from t_type where id=#{id}")
    void deleteType(Long id);
}
