package com.cn.networkdemo.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 字符串操作工具类
 */
public class StringUtil {

    /**
     * 密码输入过滤 仅限数字字母下划线
     *
     * @param pwd
     * @return
     */
    public static String pwdInputFilter(String pwd) {
        String regEx = "[^a-zA-Z0-9_]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(pwd);
        return m.replaceAll("").trim();
    }

    /**********************************************
     * 验证身份证号码
     *
     *          身份证号码
     * @return true 身份证符合规范 false 身份证有误
     */
    public static boolean checkNID(String number) {
        if (TextUtils.isEmpty(number)) {
            return false;
        }
        if (number.length() < 15 || number.length() > 18) return false;

        String pattern = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(number);
        return m.matches();
    }

    /**********************************************
     * 检测手机号码是否符合格式
     *
     * @param number
     *          手机号码
     * @return true 手机号码符合规范 flase 手机号不符合规范
     */
    public static boolean checkPhoneNumber(String number) {

        if (TextUtils.isEmpty(number)) {
            return false;
        }
        if (number.length() != 11) {
            return false;
        }
        try {
            Pattern p = Pattern.compile("(13[0-9]|14[57]|15[012356789]|18[0-9]|17[0-9])\\d{8}");
            Matcher m = p.matcher(number);
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static String formatStr(String pattern, Object value) {
        return String.format(Locale.CHINESE, pattern, value);
    }

    /**
     * 按指定格式 格式化 数字
     *
     * @param num
     * @param pattern
     * @return
     */
    public static String formatnum(double num, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(num);
    }

    /**
     * 按指定格式 格式化 数字
     *
     * @param num
     * @return
     */
    public static float formatfloat(float num, int scale) {
        int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal((double) num);
        bd = bd.setScale(scale, roundingMode);
        float ft = bd.floatValue();
        return ft;
    }

    /**
     * 调整EditText hint字体大小
     *
     * @param hint         显示的提示字符串
     * @param hintTextSize 提示字体大小
     * @return
     */
    public static SpannableString fromatETHint(String hint, int hintTextSize) {
        SpannableString ss = new SpannableString(hint);
        // 新建一个属性对象,设置文字的大小
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(hintTextSize, true);
        // 附加属性到文本
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return new SpannableString(ss);
    }

    /**
     * 检验是否数字与小数点
     *
     * @param source
     * @return
     */
    public static boolean pureNum(String source) {
        if (TextUtils.isEmpty(source)) {
            return false;
        }
        if ("null".equalsIgnoreCase(source)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher match = pattern.matcher(source);
        return match.matches();
    }

    /**
     * 判断给定字符串是否空白串 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isBlank(String input) {
        if (TextUtils.isEmpty(input)) return true;
        if ("null".equalsIgnoreCase(input)) return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    public static String cutEmail(String str) {
        if ("".equals(str)) {
            return str;
        }
        int index = str.indexOf("@");
        return str.substring(0, 1) + "****" + str.substring(index, str.length());

    }

    /**
     * 字符串拼
     *
     * @param str
     * @return
     */
    public static String JoinString(String str, String joinStr) {
        if (str == null || str.equals("")) {
            return "";
        }
        int point = str.lastIndexOf('.');
        return str.substring(0, point) + joinStr + str.substring(point);
    }

    /**
     * 返回str中最后一个separator子串后面的字符串 当str == null || str == "" || separator == ""
     * 当separator==null || 在str中不存在子串separator 时返""
     *
     * @param str       源串
     * @param separator 子串
     * @return
     */
    public static String substringAfterLast(String str, String separator) {
        if (TextUtils.isEmpty(str) || "".equals(separator)) {
            return str;
        }

        if (separator == null) {
            return "";
        }
        int idx = str.lastIndexOf(separator);
        if (idx < 0) {
            return str;
        }

        return str.substring(idx + separator.length());
    }

    /**
     * 去除字符串头部字比如 +86
     *
     * @param srcStr
     * @param head
     * @return
     */
    public static String cutHead(String srcStr, String head) {
        if (TextUtils.isEmpty(srcStr)) return srcStr;
        if (srcStr.startsWith(head)) return substringAfter(srcStr, head);
        return srcStr;
    }

    /**
     * 返回str中separator子串后面的字符串 当str == null || str == "" || separator == ""
     * 时返回str当separator==null || 在str中不存在子串separator 时返""
     *
     * @param str       源串
     * @param separator 子串
     * @return
     */
    public static String substringAfter(String str, String separator) {
        if (TextUtils.isEmpty(str) || "".equals(separator)) {
            return str;
        }

        if (separator == null) {
            return "";
        }
        int idx = str.indexOf(separator);
        if (idx < 0) {
            return "";
        }

        return str.substring(idx + separator.length());
    }

    /***
     * 全角转半
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375) c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 倒叙输出字符
     *
     * @param str
     * @return
     */
    public static String reverseSort(String str) {
        String str2 = "";
        for (int i = str.length() - 1; i > -1; i--) {
            str2 += String.valueOf(str.charAt(i));
        }

        return str2;
    }

    /**
     * 表情删除时使获取标签"的位
     *
     * @param str
     * @return
     */
    public static int getPositionEmoj(String str) {
        String[] arr = new String[str.length()];
        for (int i = str.length() - 2; i >= 0; i--) {
            arr[i] = str.substring(i, (i + 1));
            if (":".equals(arr[i])) {
                return i;
            }
        }
        return 0;
    }

    /**
     * ***替换手机号的中间四位
     *
     * @param num
     * @return
     */
    public static String replaceNum(String num) {
        if (num.length() == 0) {
            return num;
        }
        return num.substring(0, 3) + "****" + num.substring(num.length() - 4, num.length());
    }

    /**
     * 计算位数
     *
     * @return
     */
    public static double calculatePlaces(String s) {
        double valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字
            if (temp.matches(chinese)) {
                // 中文字符长度
                valueLength += 1;
            } else {
                // 其他字符长度.5
                valueLength += 0.5;
            }
        }
        // 进位取整
        return Math.ceil(valueLength);
    }

    /**
     * 截取8位字符串
     *
     * @return
     */
    public static String cutEight(String s) {
        String string = "";
        int a = 0;
        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if ((c >= 0x0391 && c <= 0xFFE5)) // 中文字符
            {
                a = a + 2;
                string = string + c;
            } else if ((c >= 0x0000 && c <= 0x00FF)) // 英文字符
            {
                a = a + 1;
                string = string + c;
            }
            if (a == 15 || a == 16) {
                return string;
            }
        }
        return s;
    }

    /**
     * 处理字符串
     *
     * @param oldStr
     * @return
     */
    public static String StrTrim(String oldStr) {
        if (oldStr == null || oldStr.trim().toLowerCase().equals("null")) return "";
        else return oldStr.trim();
    }

    public static String StrTrim(Object oject) {
        if (oject == null) return "";
        else return oject.toString().trim();
    }

    public static int StrTrimInt(Object oject) {
        int result = 0;
        if (oject == null) return 0;
        String number = String.valueOf(oject);
        if (number.equals("") || number.equals("null")) return 0;
        try {
            result = Double.valueOf(number).intValue();
            return result;
        } catch (Exception ex) {
        }
        return 0;
    }

    public static long StrTrimLong(Object oject) {
        long result = 0;
        if (oject == null) return 0;
        String number = String.valueOf(oject);
        if (number.equals("") || number.equals("null")) return 0;
        try {
            result = Double.valueOf(number).longValue();
            return result;
        } catch (Exception ex) {
        }
        return 0;
    }

    public static float StrTrimFloat(Object oject) {
        float result = 0;
        if (oject == null) return 0;
        String number = String.valueOf(oject);
        if (number.equals("") || number.equals("null")) return 0f;
        try {
            result = Double.valueOf(number).floatValue();
            return result;
        } catch (Exception ex) {
        }
        return 0f;
    }

    /**
     * 校验是否是合法的URL，应以http://开头
     *
     * @param urlString
     * @return
     */
    public static boolean isValidURLString(String urlString) {
        if (StringUtil.isBlank(urlString)) return false;

        String s = urlString.toLowerCase();

        if (((s.startsWith("http://")) || (s.startsWith("https://"))) && s.length() > 7)
            return true;

        return false;
    }

    /**
     * 格式化StringBuffer 1、非空校验 2、如果以指定字符结尾，移除掉最后一个字符
     *
     * @param sb
     * @return
     */
    public static String formatStringBuffer(StringBuffer sb, String end) {
        if (sb == null || sb.length() == 0) {
            return "";
        }
        if (end == null) end = " ";
        String str = sb.toString();
        if (str.endsWith(end)) {
            str = str.substring(0, str.length() - end.length());
        }
        return str;
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */

    public static double round(double v, int scale) {

        if (scale < 0) {

            throw new IllegalArgumentException(

                    "The scale must be a positive integer or zero");

        }

        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    /**
     * 是否是格式正常的json串
     * 简易判断  仅判断{开头 }结尾
     *
     * @param str
     * @return
     */
    public static boolean isValidJson(String str) {
        if (isBlank(str)) return false;
        if (str.startsWith("{") && str.endsWith("}")) {
            return true;
        }
        return false;
    }

    //MD5密码加密
    public static String Md5(String password) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte b[] = md.digest();

            int i;

            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            // System.out.println("result: " + buf.toString());// 32位的加密

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buf.toString();
    }

    private static final String REGEX_MOBILE = "(13[0-9]|14[57]|15[012356789]|18[0-9]|17[0-9])\\d{8}";

    public static boolean isSpecialChar(String str) {
        if (TextUtils.isEmpty(str)) return true;
        Pattern p = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]");
        Matcher m = p.matcher(str);
        boolean b = m.find();
        return b;
    }


}