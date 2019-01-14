package cn.qingmg.miscellaneous.another.util;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 正则公式工具类
 * @Author vhs
 * @Date 2018/10/5 11:17
 * @Version 1.0
 */
public class RegexUtil {

    /**
     * @param param 需要匹配的字符串
     * @param regex 正则表达式
     * @return
     */
    public static List<String> match(String param, String regex) {
        if (StringUtils.isEmpty(param)) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(param);
        List<String> list = new LinkedList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    /**
     * 判断是否匹配
     *
     * @param param 需要匹配的字符串
     * @param regex 正则表达式
     * @return
     */
    public static boolean checkRegex(String param, String regex) {
        if (StringUtils.isEmpty(param)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(param);
        return matcher.find();
    }

    public static void main(String[] args) {
        String str = "{\"aaa\": 1, \"bbb\": 2, \"ccc\": 3}";
        String regex = "\"(.+?)\"";
        for (String string: match(str, regex)) {
            System.out.println(string);
        }
    }
}
