package com.dangkang.adapter.web;

import com.dangkang.app.reportcontext.EodService;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.examplecontext.dto.request.ApplicationQueryRequestDTO;
import com.dangkang.client.examplecontext.dto.response.QueryResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Orkesh
 * @date 2023/2/23 13:37
 * 描述 :         report上下文的Adapter
 */

@RestController
public class ReportAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ReportAdapter.class);

    @Autowired
    EodService eodService ;

    @GetMapping("/do")
    @ResponseBody
    public String doGenerateReport(){
        logger.info("hahaha");
        Boolean aBoolean = eodService.execute();
        logger.info("EodService响应参数 response = [{}]",aBoolean);
        return aBoolean.toString();
    }
}
