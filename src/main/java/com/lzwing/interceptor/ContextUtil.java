package com.lzwing.interceptor;


import com.jcraft.jsch.UserInfo;

public class ContextUtil {

  public final static String SESSION_KEY = "user_token";

  private static ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<UserInfo>();

  public static UserInfo getCurrentUser() {
    return userInfoThreadLocal.get();
  }

  static void setCurrentUser(UserInfo userInfo) {
    userInfoThreadLocal.set(userInfo);
  }

  static void clear() {
    userInfoThreadLocal.remove();
  }

}