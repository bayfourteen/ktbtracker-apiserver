package com.bayfourteen.kingtiger.ktbtracker.apiserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "firebase")
public class FirebaseConfigProperties {

    private Firebase firebase;

    @Data
    public static class Firebase {

        private String apiKey;

        private String authDomain;

        private String databaseUrl;

        private String projectId;

        private String storageBucket;

        private String messagingSenderId;

        private String appId;

        private String measurementId;
    }
}
