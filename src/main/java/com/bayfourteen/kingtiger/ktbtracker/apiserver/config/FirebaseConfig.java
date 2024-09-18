package com.bayfourteen.kingtiger.ktbtracker.apiserver.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FirebaseConfig {

    private final FirebaseConfigProperties configurationProperties;

    @Bean
    @SneakyThrows
    public FirebaseApp firebaseApp() {
        final var firebaseOptions = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(firebaseOptions);

        log.info("Initialized Google Firebase Administration SDK successfully.");
        return firebaseApp;
    }

    @Bean
    public FirebaseAuth firebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }

}
