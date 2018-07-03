

package com.example.webdemo.test;

import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.junit.Assert;
//import org.junit.Test;

import java.util.*;


public class StringTest {

    //    @Test
    public void sub() {
        String msc = "1234";
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= msc.length(); i++) {
            String substr = msc.substring(0, i);
            list.add(substr);
        }
        System.out.println(list);
    }

    //    @Test
    public void file() {
        String fileName = "a/b/c/test.txt";
        if (fileName.startsWith("/") || fileName.startsWith("\\")) {
            System.out.println(fileName);
        }
        System.out.println("~~~~~~");
    }

    //    @Test
    public void fileName() {
        String fileName = "/a/b/c/test.txt";
        String substring = fileName.substring(0, fileName.lastIndexOf("/"));
        System.out.println(substring);
    }

    //    @Test
    public void nulltest() {
        String fileName = "/a/b/c/test.txt";
        String substring = fileName.substring(0, fileName.lastIndexOf("/"));
        System.out.println(substring);
    }

    //    @Test
    public void foreachtest() {
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("qwe");
        strings.add("dfg");
        strings.add("bnm");
        for (String string : strings) {
            if (string.equalsIgnoreCase("bnm")) {
                //for循环之间不能操作
                string = "1111";
            }
        }
        System.out.println(strings);
    }

    //    @Test
    public void strlengthtest() {
        String str = "WE_";
        int length = str.length();

        System.out.println(length);
    }

    //    @Test
    public void regxtest() {
        String moduleId = "HWaa89-_/@.";
        String number = "13";
        boolean matches = moduleId.matches("([a-zA-Z0-9]|-|_|/|@|\\.)*");
        boolean matches1 = number.matches("\\d+");
        System.out.println(matches1);
    }

    //    @Test
//    replaceAll支持正则匹配,replace不支持
    public void regxtest2() {
        String target = "\nhostname=\"127.10.10.11\"\n";
        System.out.println(target);
        System.out.println(target.replaceAll("hostname=\"\\d+.\\d+.\\d+.\\d+\"", "hostname=\"127.0.0.1\""));

    }

    //    @Test
    //测试if-else if-else if的执行顺序
    public void ifelsetest() {
        String abc = "abc-def-qwe";
        if (abc.contains("abc")) {
            System.out.println("包含：{}" + "abc");
        } else if (abc.contains("def")) {
            System.out.println("包含：{}" + "def");
        } else if (abc.contains("qwe")) {
            System.out.println("包含：{}" + "qwe");
        } else {
            System.out.println("都过了！");
        }
    }

    //    @Test
    public void envTest() {
        Map<String, String> env = System.getenv();
        Set<Map.Entry<String, String>> entries = env.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*********************");
        String path = System.getenv("PATH");
        System.out.println(path);
    }

    //    @Test
    public void propTest() {
        Properties prop = System.getProperties();
        Enumeration<?> enumeration = prop.propertyNames();
        if (enumeration.hasMoreElements()) {
            Object o = enumeration.nextElement();
            System.out.println(o);
        }
    }

    //    @Test
    public void stringUtilsTest() {
        //判空方法
        boolean e1 = StringUtils.isEmpty("");//true
//        Assert.assertTrue(e1);
        boolean e2 = StringUtils.isEmpty("  ");//false
//        Assert.assertFalse(e2);
        boolean e3 = StringUtils.isNotEmpty("  ");//true
//        Assert.assertTrue(e3);
        boolean e4 = StringUtils.isNotEmpty("");//false
//        Assert.assertFalse(e4);

        //
        //2）StringUtils.isNotEmpty(String str)
        //
        //3）StringUtils.isBlank(String str)
        //
        //4）StringUtils.isNotBlank(String str)
        //
        //5）StringUtils.isAnyBlank(CharSequence… css)
        //
        //6）StringUtils.isAnyEmpty(CharSequence… css)
        //
        //7）StringUtils.isNoneBlank(CharSequence… css)
        //
        //8）StringUtils.isNoneEmpty(CharSequence… css)
        //
        //9）StringUtils.isWhitespace(CharSequence cs)
    }

    //    @Test
    public void doubleForTest() {
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("1", "2", "3", "4");
        for (String s1 : list1) {
            for (String s2 : list2) {
                System.out.println(s1 + "-" + s2);
            }
            System.out.println(s1 + " not find. ");
        }
    }

    //    @Test
    public void ipv4v6Test() {
        //适合IPV4和IPV6的正则表达式
        String pattern = "^((((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:){6}((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(::([0-9a-fA-F]{1,4}:){0,4}((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:):([0-9a-fA-F]{1,4}:){0,3}((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:){2}:([0-9a-fA-F]{1,4}:){0,2}((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:){3}:([0-9a-fA-F]{1,4}:){0,1}((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:){4}:((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))|(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4})|(:((:[0-9a-fA-F]{1,4}){1,6}|:))|([0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,5}|:))|(([0-9a-fA-F]{1,4}:){2}((:[0-9a-fA-F]{1,4}){1,4}|:))|(([0-9a-fA-F]{1,4}:){3}((:[0-9a-fA-F]{1,4}){1,3}|:))|(([0-9a-fA-F]{1,4}:){4}((:[0-9a-fA-F]{1,4}){1,2}|:))|(([0-9a-fA-F]{1,4}:){5}:([0-9a-fA-F]{1,4})?)|(([0-9a-fA-F]{1,4}:){6}:))$";
        boolean matches = "192.169.0.1".matches(pattern);
        System.out.println(matches);
        boolean matches1 = "ff06:0:0:0:0:0:0:c3".matches(pattern);
        System.out.println(matches1);
        boolean matches2 = "ff06::c3".matches(pattern);
        System.out.println(matches2);
    }

    //    @Test
    public void stringBuilderTest() {
        StringBuilder builder = new StringBuilder(16);

    }

    //    @Test
    public void stringFormatTest() {
        String hwKey = String.format("cm/values/%s/datastorages/esaconfig/HW", "cluster");
        String anotherKey = String.format("cm/values/%s/datastorages/esaconfig/%s", "cluster", "node");
        System.out.println(hwKey);
        System.out.println(anotherKey);
    }


    public void stringBuilderTest2() {
        String t1 = "HelloWorld";
        t1.substring(0, t1.length() - 1);
        System.out.println(t1);
        StringBuilder builder = new StringBuilder();
        builder.append("HelloWorld");
        builder.substring(0, builder.length() - 1);
        System.out.println(builder.toString());
    }
}
