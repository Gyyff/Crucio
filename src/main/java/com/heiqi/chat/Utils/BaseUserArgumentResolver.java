package com.heiqi.chat.Utils;//package com.beamy.api.util;

import com.heiqi.chat.entity.BaseUser;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 注入当前登录的用户信息
 */
public class BaseUserArgumentResolver implements HandlerMethodArgumentResolver {

    private static Logger log = LoggerFactory.getLogger(BaseUserArgumentResolver.class);

    /**
     * 监控指定的参数
     * @param parameter 方法参数 用于校验
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(BaseUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory){

        if(parameter.getParameterType().equals(BaseUser.class)){
            HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
            assert request != null;
            String token = request.getHeader("Authorization");
            if (StringUtils.hasLength(token)) {
                try {
                    StringRedisTemplate stringRedisTemplate = SpringUtil.getApplicationContext().getBean(StringRedisTemplate.class);
                    if(!stringRedisTemplate.opsForValue().setIfPresent( token, "", 1, TimeUnit.DAYS)){
                        throw new AuthenticationException();
                    }
                    Object uid = JwtUtil.verifyAndGetValue(token, "uid");
                    Objects.requireNonNull(uid);

                    return BaseUser.BaseUserBuilder.aBaseUser()
                            .withUid(Integer.valueOf(uid.toString()))
                            .build();
                }catch (Exception e){
                    log.error("令牌失效, token = {}", token,  e);
                    throw new AuthenticationException();
                }
            }
            throw new AuthenticationException();
        }
        return null;
    }
}
