package com.example.springclient.service;

import com.example.springclient.config.ConfigurationService;
import com.example.springclient.models.UserDTO;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис по реализации методов серверно авторизации Keycloak
 */
@Service
public class KeycloakService {
    @Autowired
    ConfigurationService configurationService;

    /**
     *
     * @return получение токена авторизации
     */
    public Keycloak getToken() {
        Keycloak keycloak = KeycloakBuilder.builder().serverUrl(configurationService.getAuthServerUrl())
                .grantType(OAuth2Constants.PASSWORD).realm(configurationService.getMasterRealm()).clientId(configurationService.getMasterClientId())
                .username(configurationService.getMasterUsername()).password(configurationService.getMasterPassword())
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

        keycloak.tokenManager().getAccessToken();
        return keycloak;
    }

    /**
     *
     * @param keycloak включает в себя конфигурацию пользователя созданного на Keycloak
     * @return возвращает id клиента
     */
    public String getClientId(Keycloak keycloak) {
        String client_id = keycloak
                .realm(configurationService.getRealm())
                .clients()
                .findByClientId(configurationService.getClientId())
                .get(0)
                .getId();
        return client_id;
    }

    /**
     *
     * @param userDTO Сущность клиента в базе данных кейклока
     * @param usersResource передача созданного клиента Keycloak
     * @param userId id созданного юзера
     */
    public void setPassword(UserDTO userDTO, UsersResource usersResource, String userId) {
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(userDTO.getPassword());
        UserResource userResource = usersResource.get(userId);
        userResource.resetPassword(passwordCred);
    }

}
