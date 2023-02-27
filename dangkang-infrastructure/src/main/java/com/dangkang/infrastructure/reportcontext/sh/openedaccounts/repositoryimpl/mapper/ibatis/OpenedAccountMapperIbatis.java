package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper.ibatis;

import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.ibatis.OpenedAccountDOIbatis;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author Orkesh
 * @time 2023/2/26 22:36
 */
@Mapper
public interface OpenedAccountMapperIbatis {
    @Select("SELECT id, escrow_account_number, identity_code, full_name, created_date FROM tb_account_log WHERE DATE(created_date) BETWEEN #{date} AND #{date} ORDER BY id DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "escrowAccountNumber", column = "escrow_account_number"),
            @Result(property = "identityCode", column = "identity_code"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "createdDate", column = "created_date")
    })
    List<OpenedAccountDOIbatis> findAllByDate(@Param("date") String date, RowBounds rowBounds) ;
//
//    int getTotalElementCount(@Param("name") String date) ;
}
