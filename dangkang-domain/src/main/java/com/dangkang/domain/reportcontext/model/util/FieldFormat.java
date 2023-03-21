package com.dangkang.domain.reportcontext.model.util;


import java.util.Arrays;

/**
 * @author Orkesh
 * @date 2023/2/21 12:30
 * 描述 :         数据报表每一行内部每一个字段需进行 “左补0或右补空格”操作来支撑清算所和承办行之间的数据交换和解析。
 * 此类提供了一系列静态方法主要做以上描述的“左补0右补空格”操作
 */
public class FieldFormat {

    public static final char BLANK=32;//" "
    public static final char ZERO=48;//0

    private static void checkLength(String str){
        assert str!=null && str.length()!=0 :"输入字符串不能为null或空";
    }
    public static void check(String str, int length){
        assert str!=null && str.length()<=length :"输入字符串不能为null或空并长度不能大于"+length;
    }

    public static void check2(String str, int length) {
        if(str == null)
            throw new IllegalArgumentException("参数不能空") ;
    }

    private static final char[] fill(char c,int length){
        char[] chars=new char[length];
       Arrays.fill(chars,c);
        return chars;
    }


    /**
     * 将 C(xx) 这一类的字段进行 “右补空格”的静态方法
     * @param field 需被“右补空格” 的原字符串
     * @param requiredLength 被进行“右补空格”操作后字符串长度。（也就是 C(xx) 当中的xx 比如 C(8)）
     * @return 被进行“右补空格”操作后可进行直接传输至清算所的字段
     */
    public static String rightFillFormat(String field, int requiredLength) {
        check(field,requiredLength);
        int filledLength=requiredLength-field.length();
        if(filledLength>0)
            return new StringBuffer().append(field).append(fill(BLANK,filledLength)).toString();
        return field ;
    }

    /**
     * 将 D(xx) 这一类字段进行 “左补0” 的静态方法
     * @param field 需被“左补0” 的原数据
     * @param requiredLength 被进行 ”左补0"操作后的数字总位数（比如将 100 按照 D(10) 进行“左补0”的话
     *                       就需要最终变成 0000000100 。 这个时候requeiredLength 为10）
     * @return 被进行“左补0”操作后可进行直接传输至上清所的字段
     */
    public static String leftFillFormat(Long field, int requiredLength) {
        String strField=String.valueOf(field);
        int filledLength=requiredLength-strField.length();
        if(filledLength>0)
            return new StringBuffer().append(fill(ZERO,filledLength)).append(strField).toString();
        return strField;
    }

    /**
     * 将 D(xx, yy) 这一类字段进行 “左补0”的静态方法
     * @param originalNum 需被“左补0” 的原数据
     * @param totalLength 被进行 “左补0”操作后的数字总位数 （比如将100 按照 D(6, 2) 进行“左补0”的话
     *                       就需要最终变成 010000 。 既总位数6，小数点后包含2位）
     * @return 被进行 “左补0” 操作后可进行直接传输至上清所的字段
     */
    public static String leftFillFormat(Double originalNum, int totalLength,int dotLength) {
        String strFormat=new StringBuffer("%.").append(dotLength).append("f").toString();
        String strNum = String.format(strFormat, originalNum) ;
       strNum=strNum.replace(".","");
       int filledLength=totalLength-strNum.length();
       if(filledLength>0)
            return new StringBuffer().append(fill(ZERO,filledLength)).append(strNum).toString();
       return strNum;
    }
}
