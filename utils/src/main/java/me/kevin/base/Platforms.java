package me.kevin.base;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * @author Kevin
 * @description 平台信息相关
 * @date 2017/1/19
 */
public abstract class Platforms {
    // 文件路径分隔符
    public static final String FILE_PATH_SEPARTOR = File.separator;
    public static final char FILE_PATH_SEPARTOR_CHAR = File.separatorChar;

    // ClassPath分隔符
    public static final String CLASS_PATH_SEPARTOR = File.pathSeparator;
    public static final char CLASS_PATH_SEPARTOR_CHAR = File.pathSeparatorChar;

    // 临时目录
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    // 当前应用工作目录
    public static final String WORKING_DIR = System.getProperty("user.dir");
    // Java HOME目录
    public static final String JAVA_HOME = System.getProperty("java.home");

    // Java版本
    public static final String JAVA_SPECIFICATION_VERSION = System.getProperty("java.specification.version");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final boolean IS_JAVA6 = JAVA_SPECIFICATION_VERSION.startsWith("1.6");
    public static final boolean IS_JAVA7 = JAVA_SPECIFICATION_VERSION.startsWith("1.7");
    public static final boolean IS_JAVA8 = JAVA_SPECIFICATION_VERSION.startsWith("1.8");
    public static final boolean IS_ATLEASET_JAVA6 = IS_JAVA6 || IS_JAVA7 || IS_JAVA8;
    public static final boolean IS_ATLEASET_JAVA7 = IS_JAVA7 || IS_JAVA8;
    public static final boolean IS_ATLEASET_JAVA8 = IS_JAVA8;

    // 操作系统类型及版本
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");
    public static final String OS_ARCH = System.getProperty("os.arch");
    public static final boolean IS_LINUX = OS_NAME.toLowerCase().startsWith("linux");
    public static final boolean IS_UNIX = OS_NAME.toLowerCase().startsWith("unix");
    public static final boolean IS_WINDOWS = OS_NAME.toLowerCase().startsWith("windows");


    // 换行符 common-lang3
    public static final String LINE_SEPARATOR = SystemUtils.LINE_SEPARATOR;
    // 要求JDK1.7
    public static final String LINE_SEPARATOR2 = System.lineSeparator();
    //
    public static final String LINE_SEPARATOR3 = IS_WINDOWS ? "\r\n" : "\n";

    public static int getPid() {
        // format: "pid@hostname"
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] split = name.split("@");
        if (split.length != 2) {
            return -1;
        }

        try {
            return Integer.parseInt(split[0]);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
