package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl;

import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.ibatis.OpenedAccountDOIbatis;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper.ibatis.OpenedAccountMapperIbatis;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl.DB_DATE_FORMAT;

/**
 * @author Orkesh
 * @time 2023/2/26 22:51
 */
@Repository
public class TestRepositoryImpl {

    @Autowired
    OpenedAccountMapperIbatis mapper ;

    public List<OpenedAccountDOIbatis> findAllByDate (Date date, RowBounds rowBound) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DB_DATE_FORMAT) ;
        List<OpenedAccountDOIbatis> allByDate = mapper.findAllByDate(simpleDateFormat.format(date), rowBound);
        return allByDate ;
    }
}
