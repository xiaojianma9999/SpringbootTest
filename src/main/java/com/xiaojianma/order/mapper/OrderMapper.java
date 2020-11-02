package com.xiaojianma.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    @Insert("INSERT INTO ORDER_NUMBER (NUMBER) VALUES (#{number});")
    int insertMember(@Param("number") String number);
}
