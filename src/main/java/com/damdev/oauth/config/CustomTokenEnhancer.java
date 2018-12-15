package com.damdev.oauth.config;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * Author : zenic
 * Created : 15/12/2018
 */
@Slf4j
@Configuration
public class CustomTokenEnhancer implements TokenEnhancer {

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken,
    OAuth2Authentication oAuth2Authentication) {
    log.info("토큰 생성");

    Map<String, Object> additionalInfo = new HashMap<>();
    // CustomUserDetails 에서 정보를 가지고 온다

    // 여기서 필요한 정보 추가
    additionalInfo.put("id", "seqId");
    additionalInfo.put("userId", "userId");
    additionalInfo.put("status", "status");
    additionalInfo.put("role", "role");

    ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
    return oAuth2AccessToken;
  }
}
