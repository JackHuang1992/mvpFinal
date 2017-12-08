package example.hspmvp.com.mvpfinal.utils;
/**
 * author: 黄士鹏
 * created on: 2017/12/1 11:59
 * description: 字符串输入验证工具类
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class XStringCheckUtils {

//    public static final String REGEX_CHINESE = "[\u4e00-\u9fa5]";

    /**
     * 判断是否是汉字
     *
     * @param str
     * @return
     */
    public static boolean isRegexChinese(String str) {
        Pattern p = Pattern.compile(REGEX_CHINESE);
        Matcher m = p.matcher(str);
        int length = str.length();
        int count = 0;

        while (m.find()) {
            count++;
        }

        if (count < length) {
            return false;
        }

        return true;
    }

    /**
     * 判断是否存在特殊字符
     * 用户名 判断
     *
     * @param str
     * @return
     */
    public static boolean isSpecialCharacter(String str) {
        String regEx = "[a-zA-Z][a-zA-Z0-9_]{0,15}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 性别判断
     *
     * @param str
     * @return
     */
    public static boolean isSpecialCharacterSex(String str) {
        String regEx = "[\u4E00-\u9FA5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 就诊人名判断
     *
     * @param str
     * @return
     */
    public static boolean isSpecialCharacter1(String str) {
        String regEx = "[\u4E00-\u9FA5]{2,5}";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 判断是否是邮箱格式
     *
     * @param strEmail
     * @return
     */
    public static boolean isEmail(String strEmail) {
//		String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        String strPattern = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }

    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断是否为手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        String strPattern = "1[34578]{1}\\d{9}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断用户昵称长度
     *
     * @param mobiles
     * @return
     */
    public static boolean isNickName(String mobiles) {
        String strPattern = "^.{2,10}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 首字母大写
     *
     * @param s 待转字符串
     * @return 首字母大写字符串
     */
    public static String upperFirstLetter(String s) {
        if (isEmpty(s) || !Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * 判断字符串是否为null或长度为0
     *
     * @param s 待校验字符串
     * @return {@code true}: 空<br> {@code false}: 不为空
     */
    public static boolean isEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }

    //正则表达式：验证用户名
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";
    //正则表达式：验证密码
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    //正则表达式：验证手机号
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    //正则表达式：验证邮箱
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    //正则表达式：验证汉字
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    //正则表达式：验证URL
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    //正则表达式：验证身份证
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /*正则表达式：验证IP地址*/
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";



    /*校验通过返回true，否则返回false*/
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }


    /*校验通过返回true，否则返回false*/
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }



    /*校验通过返回true，否则返回false */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }



    /* 校验邮箱 @param email @return 校验通过返回true，否则返回false*/
    public static boolean isNewEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }


    /*校验汉字@param chinese @return 校验通过返回true，否则返回false*/
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }


    /*校验身份证 @param idCard@return 校验通过返回true，否则返回false */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }



    /*校验URL@param url@return 校验通过返回true，否则返回false  */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }


    /*校验IP地址 @param ipAddr @return  */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);

    }


    //新版手机号码正则式
    public static boolean isChinaPhoneNumber(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
