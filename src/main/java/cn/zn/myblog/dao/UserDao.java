package cn.zn.myblog.dao;

import cn.zn.myblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Repository 需要用@MapperScan扫描mapper才能注入@Bean
 * @Mapper注解 相当于@Repository注解+@MapperScan注解,通过xml文件下的namespace命名空间自动注入bean
 * 为啥都得加？？？
 */
@Repository
@Mapper
public interface UserDao {

    @Select("select * from t_user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(User user);
}
