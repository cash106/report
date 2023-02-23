package com.dangkang.infrastructure.reportcontext.repositoryimpl.mapper ;

import com.dangkang.infrastructure.reportcontext.repositoryimpl.dataobject.OpenedAccountDO ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.query.Param;
/**
 * @author Orkesh
 * @date 2023/2/23 9:36
 * 描述 :         开户数据 ORM映射
 */
public interface OpenedAccountMapper extends JpaRepository<OpenedAccountDO, Long> {

    @Query(value = "SELECT id, escrow_account_number, identity_code, full_name, created_date FROM tb_account_log WHERE DATE(created_date) BETWEEN ?1 AND ?1", nativeQuery = true)
    Page<OpenedAccountDO> findAllByDate(String date, Pageable pageable) ;

    @Query(value = "SELECT count(1) FROM tb_account_log WHERE DATE(created_date) BETWEEN ?1 AND ?1", nativeQuery = true)
    Integer getTotalElementCount(@Param("startDate")String start) ;
}
