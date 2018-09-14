package com.stl.cloud.authserver.config;

import com.stl.cloud.authserver.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Qualifier
    private DataSource dataSource;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 客户端数据保存在数据库中
        // clients.withClientDetails(new JdbcClientDetailsService(dataSource));
        clients.inMemory().withClient("service-feign")// 创建一个客户端 名字是user-service
                .secret("123456").scopes("read", "write")
                .authorizedGrantTypes("authorization_code"/*"password", "refresh_token"*/)
                // token过期时间
                .accessTokenValiditySeconds(3600)
                // refresh过期时间
                .refreshTokenValiditySeconds(3600);
    }

    // @Override
    // public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    //     endpoints.authenticationManager(authenticationManager)
    //             // 配置JwtAccessToken转换器
    //             .accessTokenConverter(jwtAccessTokenConverter())
    //             // refresh_token需要userDetailsService
    //             .reuseRefreshTokens(false).userDetailsService(userDetailsService);
    //             // .tokenStore(tokenStore())
    //
    //     // endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtAccessTokenConverter()).authenticationManager(authenticationManager);
    // }
    //
    // @Override
    // public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
    //     // 开启/oauth/token_key验证端口无权限访问
    //     oauthServer.tokenKeyAccess("permitAll()")
    //             // 开启/oauth/check_token验证端口认证权限访问
    //             .checkTokenAccess("isAuthenticated()");
    // }
    //
    // @Bean
    // public TokenStore tokenStore() {
    //     return new JwtTokenStore(jwtAccessTokenConverter());
    // }
    //
    // @Bean
    // protected JwtAccessTokenConverter jwtAccessTokenConverter() {
    //     KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("stl-jwt.jks"), "123456" .toCharArray());
    //     JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    //     converter.setKeyPair(keyStoreKeyFactory.getKeyPair("stl-jwt"));
    //     return converter;
    // }
    //
    // @Autowired
    // public void setDataSource(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }
}
