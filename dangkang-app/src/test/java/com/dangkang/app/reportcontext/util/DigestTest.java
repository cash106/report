package com.dangkang.app.reportcontext.util;

import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * @author Orkesh
 * @time 2023/3/14 11:34
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class DigestTest {

    @InjectMocks
    Digest digest ;
    @Mock
    ReportConfig reportConfig ;

    @Test
    public void testExecute () {
        when(reportConfig.getRootPath()).thenReturn("C:\\cash\\material\\codingWork\\github-ddd-report\\reportfileDirectory\\") ;
        String reportFileName = "BankAccountOpen.txt" ;
        String returnedStr = digest.execute(reportFileName) ;
        Assert.assertNotNull(returnedStr) ;
    }
}
