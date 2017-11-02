package com.xjp.oauthServer.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2017-10-31 17:46
 */

public class SsoAuthProvider implements AuthenticationProvider {

  private static final Logger _LOGGER = LoggerFactory.getLogger(SsoAuthProvider.class);

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    _LOGGER.debug("自定义provider");
    // 返回一个Token对象表示登陆成功
    return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),
        Collections.<GrantedAuthority>emptyList());
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}
