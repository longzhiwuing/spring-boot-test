package com.lzwing.aop.security;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/8
 * Time: 10:35
 */
public class CurrentUserHolder {
    public static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String get() {
        return holder.get() == null ? "unknow" : holder.get();
    }

    public static void set(String user) {
        holder.set(user);
    }
}
