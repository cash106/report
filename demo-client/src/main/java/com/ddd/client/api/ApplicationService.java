package com.ddd.client.api;

import com.ddd.client.dto.result.ApplicationServiceResult;
import com.ddd.client.dto.valueobject.ApplicationServiceVO;

/**
 * 债券相关服务
 */
public interface ApplicationService {

    /**
     */
    ApplicationServiceResult execute(ApplicationServiceVO applicationServiceVO);

    /**
     */
//    void cash();
}
