package com.dangkang.infrastructure.logmasking;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.dangkang.infrastructure.logmasking.datamasking.DataMask;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.stream.Stream;

/**
 * @date 2022/12/21 16:18
 */
public class MaskConverter  extends MessageConverter {
    public MaskConverter(){

    }

    @Override
    public String convert(ILoggingEvent event) {
        try {
            return this.doMask(event);
        } catch (Exception e) {
            return super.convert(event);
        }
    }

    private String doMask(ILoggingEvent event){
        try{
            Object[] objects = Stream.of(event.getArgumentArray()).map(obj -> {
               String msg;
               if(obj instanceof String){
                   msg = obj.toString();
               }else{
                   msg = DataMask.toJSONString(obj);
               }
               return msg;
            }).toArray();
            String eventMessage = event.getMessage();
            FormattingTuple formattingTuple = MessageFormatter.arrayFormat(eventMessage,objects);
            String s = formattingTuple.getMessage();
            return s;
        }catch (Exception e){
            return event.getMessage();
        }
    }

}
