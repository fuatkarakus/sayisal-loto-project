package com.sayisal.loto;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SayisalLotoApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;
	
	
	@Test
    public void connectionTest() throws Exception {
        assertThat(this.restTemplate.getForObject( "http://www.millipiyango.gov.tr/sonuclar/cekilisler/sayisal/SAY_20181124.json",
                String.class)).contains("SAYISAL_LOTO");
    }

	@Test
	public void dateTest() throws Exception {
		LocalDate localDate = LocalDate.now();
		String date = DateTimeFormatter.ofPattern("yyyyMMdd").format(localDate);
		String now = "20181127";
		assertThat(date.contains(now));
	}
 }
