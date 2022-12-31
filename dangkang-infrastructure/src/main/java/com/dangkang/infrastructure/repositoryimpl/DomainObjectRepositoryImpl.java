package com.dangkang.infrastructure.repositoryimpl;

import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.exception.DataBaseException;
import com.dangkang.domain.exception.database.DataBaseErrorManager;
import com.dangkang.domain.model.trade.DomainObject;
import com.dangkang.domain.model.trade.repository.DomainObjectRepository;
import com.dangkang.infrastructure.converter.DomainObjectConverter;
import com.dangkang.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
import com.dangkang.infrastructure.repositoryimpl.mapper.DomainObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class DomainObjectRepositoryImpl implements DomainObjectRepository {

    @Autowired
    private DomainObjectMapper domainObjectMapper;


    @Override
    public DomainObject findAndCheckEmpty(String phoneNumber) {

       DomainObjectDO domainObjectDO = domainObjectMapper.select(phoneNumber);
       if(domainObjectDO==null){
           throw new ApplicationException().setErrorCode(ERR_DOMAINOBJECT_NOT_FOUND_CODE)
                                            .setPromptMessage(ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE);
       }
       return DomainObjectConverter.INSTANCE.toDomainObject(domainObjectDO);
       
    }

    @Override
    public void save(DomainObject domainObject) {
    }

    @Override
    public void update(DomainObject domainObject) {

        DomainObjectDO domainObjectDO = DomainObjectConverter.INSTANCE.toDomainObjectDO(domainObject);

        try {
            domainObjectMapper.update(domainObjectDO);
        } catch (Exception e) {
            throw new DataBaseException().setPromptMessage(DataBaseErrorManager.ERR_DATABASE_MESSAGE)
                                         .setCause(e);
        }
    }
}
