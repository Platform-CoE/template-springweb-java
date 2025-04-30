package {{ cookiecutter.package_name }}.mapper;

import {{ cookiecutter.package_name }}.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity selectUserById(@Param("id") Long id);
    List<UserEntity> selectAllUsers();
    void insertUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(@Param("id") Long id);
} 