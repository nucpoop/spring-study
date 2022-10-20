package com.nucpoop.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucpoop.server.api.WeatherAPI;
import com.nucpoop.server.dto.request.WeatherRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	WeatherAPI weatherAPI;

	@Test
	void call_api_test() {
		//given
		WeatherRequest request = new WeatherRequest(1,1000,"JSON","20221020","1200",55,127);
		System.out.println("given ServiceKey : " + request.getServiceKey());
		//when
		String result = weatherAPI.callAPI(request,"/getUltraSrtNcst");

		//then

		System.out.println(result);

	}

}
