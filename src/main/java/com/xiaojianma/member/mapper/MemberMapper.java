package com.xiaojianma.member.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    @Insert("INSERT INTO USER (NAME, AGE) VALUES (#{name}, #{age});")
    int insertMember(@Param("name") String name, @Param("age") Integer age);
}
