package com.bayfourteen.kingtiger.ktbkracker.apiserver;

import org.springframework.boot.SpringApplication;

public class TestKingTigerBlackBeltTrackingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(KingTigerBlackBeltTrackingServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
