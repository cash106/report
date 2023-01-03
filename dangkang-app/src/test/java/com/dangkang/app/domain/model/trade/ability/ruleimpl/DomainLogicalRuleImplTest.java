package com.dangkang.app.domain.model.trade.ability.ruleimpl;

import com.dangkang.domain.model.trade.DomainObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
@RunWith(MockitoJUnitRunner.class)
public class DomainLogicalRuleImplTest {

    private static final Logger logger = LoggerFactory.getLogger(DomainLogicalRuleImplTest.class);

    @Test
    public void checkTest(){
        DomainObject domainObject = new DomainObject();
        domainObject.setPhoneNumber("17600405800");
        logger.info("领域对象domainObject = [{}]",domainObject);
    }
}
