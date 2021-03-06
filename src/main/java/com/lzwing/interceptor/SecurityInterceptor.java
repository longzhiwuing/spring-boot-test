package com.lzwing.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class SecurityInterceptor implements HandlerInterceptor {


  /*@Autowired
  @Qualifier("authServiceImpl")
  private IAuthService authService;

  @Autowired
  @Qualifier("userServiceImpl")
  private IUserService userService;

  private Cache<String, UserInfo> userInfoCache =
      CacheBuilder.newBuilder().expireAfterWrite(20, TimeUnit.MINUTES).build();
  */


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    /*if (request.getRequestURI().equals("/loginPost")) {
      return true;
    }
    String token = "";
    HttpSession session = request.getSession();
    if (session.getAttribute(ContextUtil.SESSION_KEY) != null) {
      token = session.getAttribute(ContextUtil.SESSION_KEY).toString();
    } else {
      token = request.getHeader("X-Auth-Token");
    }
    TokenInfo tokenInfo = authService.getTokenInfo(token);
    if (tokenInfo == null) {
      String url = "/loginPost";
      response.sendRedirect(url);
      //response.setStatus(403);
      return false;
    }
    UserInfo userInfo = userInfoCache.getIfPresent(tokenInfo.getToken());
    if (userInfo == null) {
      userInfo = userService.getUserInfo(token);
      if (userInfo == null) {
        userInfo = new UserInfo();
        userInfo.setUserId(token);
        userInfo.setUserName("NOT_EXIST_USER");
        userInfo.setDetail("a temporary visitor");
        userInfo.setSystemRole(SystemRole.VISITER);
      }
      userInfoCache.put(tokenInfo.getToken(), userInfo);
    }
    ContextUtil.setCurrentUser(userInfo);*/
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {

  }
}
