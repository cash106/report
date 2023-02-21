package com.dangkang.domain.reportcontext.util;


/**
 * @author Orkesh
 * @date 2023/2/21 12:30
 * 描述 :         数据报表每一行内部每一个字段需进行 “左补0或右补空格”操作来支撑清算所和承办行之间的数据交换和解析。
 * 此类提供了一系列静态方法主要做以上描述的“左补0右补空格”操作
 */
public class SuplementColumnLengthUtil {

    /**
     * 将 C(xx) 这一类的字段进行 “右补空格”的静态方法
     * @param originalStr 需被“右补空格” 的原字符串
     * @param requiredLength 被进行“右补空格”操作后字符串长度。（也就是 C(xx) 当中的xx 比如 C(8)）
     * @return 被进行“右补空格”操作后可进行直接传输至清算所的字段
     */
    public static String completeLengthOfC(String originalStr, int requiredLength) {
        /* 如果所输入的需要 “右补空格” 的原字符串长度 == 目标字符串长度 */
        if(originalStr.length() == requiredLength)
            return originalStr ;
        /* 如果所输入的需要 “右补空格” 的原字符串长度 > 目标字符串长度 */
        else if (originalStr.length() > requiredLength)
            return null ;
        /* 如果所输入的需被“右补空格”的字符串长度确实 < 目标字符串长度，则开始进行 “右补空格操作 */
        StringBuilder builder = new StringBuilder() ;
        for (int i = 0 ; i < requiredLength - originalStr.length() ; ++ i)
            builder.append(" ") ;
        return builder.toString() ;
    }

    /**
     * 将 D(xx) 这一类字段进行 “左补0” 的静态方法
     * @param originalNum 需被“左补0” 的原数据
     * @param requiredLength 被进行 ”左补0"操作后的数字总位数（比如将 100 按照 D(10) 进行“左补0”的话
     *                       就需要最终变成 0000000100 。 这个时候requeiredLength 为10）
     * @return 被进行“左补0”操作后可进行直接传输至上清所的字段
     */
    public static String completeLengthOfDWithoutDot(Long originalNum, int requiredLength) {
        /* 如果所输入的需要 “左补0” 的原数字位数总数 == 目标数字位数总数 */
        if(originalNum.toString().length() == requiredLength)
            return originalNum.toString() ;
        /* 如果所输入的需要 “左补0” 的原数字位数总数 > 目标数字位数总数 */
        else if(originalNum.toString().length() > requiredLength)
            return null ;
        /* 如果所输入的需要 “左补0” 的原数字位数总数 < 目标数字位数总数 */
        StringBuilder builder = new StringBuilder() ;
        for(int i = requiredLength - originalNum.toString().length() ; i > 0 ; -- i )
            builder.append("0") ;
        builder.append(originalNum.toString()) ;
        return builder.toString() ;

    }

    /**
     * 将 D(xx, yy) 这一类字段进行 “左补0”的静态方法
     * @param originalNum 需被“左补0” 的原数据
     * @param requeredLength 被进行 “左补0”操作后的数字总位数 （比如将100 按照 D(6, 2) 进行“左补0”的话
     *                       就需要最终变成 010000 。 既总位数6，小数点后包含2位）
     * @return 被进行 “左补0” 操作后可进行直接传输至上清所的字段
     */
    public static String completeLengthOfDWithDot(Double originalNum, int requeredLength) {
        String numStr = String.format("%.2f", originalNum) ;
        /* 如果所输入的需 “左补0” 的原“带小数点的数字”总位数 == 目标“带小数点的数字”总位数 */
        if(numStr.length() - 1 == requeredLength)
            return numStr ;
        /* 如果所输入的需 “左补0” 的原“带小数点的数字”总位数 > 目标“带小数点的数字”总位数 */
        else if (numStr.length() - 1 > requeredLength)
            return null ;
        /* 如果所输入的需 “左补0” 的原“带小数点的数字”总位数 < 目标“带小数点的数字”总位数，则可以开始进行处理 */
        String partBeforeDot = numStr.substring(0, numStr.lastIndexOf(".")) ;
        String partAfterDot = numStr.substring(numStr.lastIndexOf(".") + 1) ;
        String totalPart = partBeforeDot + partAfterDot ;
        StringBuilder builder = new StringBuilder() ;
        for(int i = (requeredLength - totalPart.length()) ; i > 0 ; -- i)
            builder.append("0") ;
        builder.append(totalPart) ;
        return builder.toString() ;
    }
}
