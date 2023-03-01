package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper;

import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.OpenedAccountDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Orkesh
 * @time 2023/2/26 22:36
 */
@Mapper
public interface OpenedAccountMapper {
    @Select("SELECT id, escrow_account_number, identity_code, full_name, created_date FROM tb_account_log WHERE DATE(created_date) BETWEEN #{date} AND #{date} ORDER BY id DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "escrowAccountNumber", column = "escrow_account_number"),
            @Result(property = "identityCode", column = "identity_code"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "createdDate", column = "created_date")
    })
    List<OpenedAccountDO> pageFind(@Param("date") String date) ;

    @Select("SELECT count(1) FROM tb_account_log WHERE DATE(created_date) BETWEEN #{date} AND #{date}")
    Integer getRecordTotalCount(@Param("date") String date) ;

    @Insert({
            "<script>",
            "insert into tb_account_log(created_date, escrow_account_number, full_name, identity_code) values ",
            "<foreach collection='openedaccounts' item='item' index='index' separator=','>",
            "(#{item.createdDate}, #{item.escrowAccountNumber}, #{item.fullName}, #{item.identityCode})",
            "</foreach>",
            "</script>"
    })
    int insertCollectList(@Param(value="openedaccounts") List<OpenedAccountDO> openedaccounts);
}
