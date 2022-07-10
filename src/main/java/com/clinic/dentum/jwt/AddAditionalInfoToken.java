package com.clinic.dentum.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.clinic.dentum.interfaces.ICustomerService;
import com.clinic.dentum.model.Customer;

import java.util.HashMap;
import java.util.Map;

@Component
public class AddAditionalInfoToken implements TokenEnhancer {

    @Autowired
    private ICustomerService customerService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Map<String, Object> info = new HashMap<>();

        Customer customer = customerService.findByUsername(authentication.getName());

        info.put("dni", customer.getDni());
        info.put("enabled", customer.getEnabled());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

}
