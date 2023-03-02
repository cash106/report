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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class OpenedAccountTest {

    /* 需在生成假数据阶段所生成的假数据总数 */
    private static final int COUNT = 203 ;

    /* 在生成假数据阶段，开户时间需锁定在最近几天 */
    private static final int RECENT_DAYS = 2 ;
    private  List<OpenedAccountDO> openedAccountList;
    @Autowired
    OpenedAccountsRepositoryImpl openedAccountsRepository;

    @Autowired
    OpenedAccountGenerateReportService openedAccountGenerateReportService ;

    @BeforeAll
    @Test
    @DisplayName("生成测试数据")
    public void prepareTestData() {
        openedAccountList = generateOpenedAccountTestData(COUNT);
    }

    @Test
    @DisplayName("将测试数据持久化至关系型数据库")
    @Ignore
    public void testBatchSaveToDB () {
        /* 将其持久化至关系型数据库 */
        int affectedRows = openedAccountsRepository.batchSaveToDB(openedAccountList);
        Assert.assertEquals(COUNT, affectedRows);
    }

    /* 将插入到数据库中的数据取出来测试 */
    @Test
    @DisplayName("从关系型数据库读数据转换成PageResponse对象的测试")
    public void testPageFind() throws ParseException {
        Date queryDate=new SimpleDateFormat(DB_DATE_FORMAT).parse("2023-03-01");
        PageResponse<Node> page = openedAccountsRepository.pageFind(queryDate, 1, 10) ;
        Assert.assertNotEquals(null, page.getData()) ;
    }

    @Test
    @DisplayName("生成报表文件测试")
    public void testGenerateReportService() {
        String returntedResult = openedAccountGenerateReportService.execute() ;
        Assert.assertEquals("BankAccountOpen.txt", returntedResult) ;
    }

    /**
     * 生成随机开户数据各字段数组的方法
     * @param count 需要生成的开户数据总数
     * @return
     */
    private List<OpenedAccountDO> generateOpenedAccountTestData(int count) {
        /* 托管账号 */
        List<OpenedAccountDO> list = new ArrayList<>(count) ;
        for(int i = 0 ; i < count ; ++ i ) {
            String escrowAccount = RandomSource.personInfoSource().randomCreditCardNo(CreditCardType.UnionPay);
            /* 身份识别码 */
            LocalDate beginDate = LocalDate.of(1950,11,11);
            LocalDate endDate = LocalDate.of(1999,12,12);
            String identityCode = RandomSource.personInfoSource().randomMaleIdCard(Province.XJ, beginDate, endDate);
            /* 开户人全称 */
            String investorName = RandomSource.personInfoSource().randomChineseName();
            /* 开户日期 */
            Date openedDate = RandomSource.dateTimeSource().randomPastDate(RECENT_DAYS);
            OpenedAccountDO openedAccountDO=new OpenedAccountDO()
                    .setEscrowAccountNumber(escrowAccount)
                    .setIdentityCode(identityCode)
                    .setFullName(investorName)
                    .setCreatedDate(openedDate);
            list.add(openedAccountDO) ;
        }
        return list ;
    }
}
