package com.dangkang.infrastructure.reportcontext.util;

import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:52
 * 描述 :         报表文件的操作因是IO操作，故在基础设施层准备了进行IO输出（相当于数据库写）操作的数据仓
 */
@Component
public class ReportFile {

    @Autowired
    ReportConfig reportConfig ;

    public void save(PageResponse<Node> page, String reportFileName) {
        List<Node> nodeList=page.getData();
        if(nodeList == null || nodeList.size() == 0) return ;
        File file = new File(reportConfig.getRootPath() + reportFileName) ;
        try (
                BufferedWriter reportWriter =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream(file, true), reportConfig.getCharset()
                                )
                        )
        ){
            StringBuffer buffer=new StringBuffer();
            for(Node node:nodeList){
                buffer.append(node);
            }
            reportWriter.write(buffer.toString()) ;
            reportWriter.flush() ;
        } catch (UnsupportedEncodingException e) {
            throw new ApplicationException().setPromptMessage("当前用的字符集是: %s", reportConfig.getCharset()).setCause(e) ;
        } catch (FileNotFoundException e) {
            throw new ApplicationException().setPromptMessage("当前文件为: %s", file.getAbsolutePath()).setCause(e) ;
        } catch (IOException e) {
            throw new ApplicationException().setPromptMessage("").setCause(e) ;
        }
    }
}
