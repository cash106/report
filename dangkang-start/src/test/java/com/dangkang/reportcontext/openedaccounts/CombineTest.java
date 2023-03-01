package com.dangkang.reportcontext.openedaccounts;

import com.apifan.common.random.RandomSource;
import com.apifan.common.random.constant.CreditCardType;
import com.apifan.common.random.constant.Province;
import com.dangkang.DangkangApplication;
import com.dangkang.app.reportcontext.sh.openedaccounts.serviceimpl.OpenedAccountGenerateReportService;
import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.OpenedAccountDO;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.image.ImageWatched;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl.DB_DATE_FORMAT;

/**
 * @author Orkesh
 * @time 2023/3/1 12:13
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = DangkangApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(value = MethodSorters.DEFAULT)
public class CombineTest {

    /* 需在生成假数据阶段所生成的假数据总数 */
    private static final int fakeDataCount = 50 ;

    /* 在生成假数据阶段，开户时间需锁定在最近几天 */
    private static final int fakeDataRecentDays = 2 ;
    private static ArrayList<OpenedAccountDO> openedAccountDOArrayList ;
    @Autowired
    OpenedAccountsRepositoryImpl repository ;

    @Autowired
    OpenedAccountGenerateReportService openedAccountGenerateReportService ;

    @BeforeAll
    @Test
    @DisplayName("制造假数据")
    public void testA() {
        /* 制造一批假开户数据插入到持久化机制（关系型数据库） */
        openedAccountDOArrayList = generateOpenedAccountDOList(generateAFakeDataColumnsArrs(fakeDataCount));
        Assert.assertEquals(fakeDataCount, openedAccountDOArrayList.size());
    }

    @Test
    @DisplayName("将制造的假数据持久化至关系型数据库")
    @Ignore
    public void testB () {
        /* 将其持久化至关系型数据库 */
        int affectedRows = repository.batchSaveToDB(openedAccountDOArrayList);
        Assert.assertEquals(fakeDataCount, affectedRows);
    }

    /* 将插入到数据库中的数据取出来测试 */
    @Test
    @DisplayName("从关系型数据库读数据转换成PageResponse对象的测试")
    public void testC() throws ParseException {
        PageResponse<Node> page = repository.pageFind(new SimpleDateFormat(DB_DATE_FORMAT).parse("2023-03-01"), 1, 100) ;
        Assert.assertNotEquals(null, page.getData()) ;
    }

    @Test
    @DisplayName("生成报表文件至本实例所在物理机磁盘的测试")
    public void testD() {
        String returntedResult = openedAccountGenerateReportService.execute() ;
        Assert.assertEquals("BankAccountOpen.txt", returntedResult) ;
    }

    /**
     * 生成随机开户数据各字段数组的方法
     * @param dataCount 需要生成的开户数据总数
     * @return
     */
    private LinkedList<Object[]> generateAFakeDataColumnsArrs (int dataCount) {
        /* 托管账号 */
        LinkedList<Object[]> list = new LinkedList<>() ;
        for(int i = 0 ; i < dataCount ; ++ i ) {
            String fakeEscrowAccount = RandomSource.personInfoSource().randomCreditCardNo(CreditCardType.UnionPay);
            /* 身份识别码 */
            LocalDate beginDate = LocalDate.of(1950,11,11);
            LocalDate endDate = LocalDate.of(1999,12,12);
            String fakeIdentityNumber = RandomSource.personInfoSource().randomMaleIdCard(Province.XJ, beginDate, endDate);
            /* 开户人全称 */
            String chineseName = RandomSource.personInfoSource().randomChineseName();
            /* 开户日期 */
            LocalDateTime openedDate = RandomSource.dateTimeSource().randomPastTime(fakeDataRecentDays);
            Object[] columnArr = new Object[] {fakeEscrowAccount, fakeIdentityNumber, chineseName, openedDate} ;
            list.add(columnArr) ;
        }
        return list ;
    }

    /**
     * 将随机生成的开户数据字段拼接成完整开户数据DATA OBJECT对象List的方法
     * @param columnArrList 原开户数据各字段数组的List
     * @return
     */
    private ArrayList<OpenedAccountDO> generateOpenedAccountDOList (LinkedList<Object[]> columnArrList) {
        ArrayList<OpenedAccountDO> openedAccountDOArrayList = new ArrayList<>() ;
        int countOfLoop = columnArrList.size() ;
        for(int i = 0 ; i < countOfLoop ; ++ i ) {
            Object[] currentColumnArr = columnArrList.pop() ;
            LocalDateTime localDateTime = (LocalDateTime)currentColumnArr[3] ;
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
            openedAccountDOArrayList.add(new OpenedAccountDO()
                    .setEscrowAccountNumber((String)currentColumnArr[0])
                    .setIdentityCode((String)currentColumnArr[1])
                    .setFullName((String)currentColumnArr[2])
                    .setCreatedDate(Date.from(zonedDateTime.toInstant())) );
        }
        return openedAccountDOArrayList ;
    }
}
