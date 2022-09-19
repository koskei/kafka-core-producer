package com.beacon.kafkacoreproducer;

import com.beacon.kafkacoreproducer.Producer.EmployeeJsonProducer;
import com.beacon.kafkacoreproducer.Producer.Images2Producer;
import com.beacon.kafkacoreproducer.Producer.ImagesProducer;
import com.beacon.kafkacoreproducer.Producer.InvoiceProducer;
import com.beacon.kafkacoreproducer.Producer.KafkaProducer;
import com.beacon.kafkacoreproducer.Producer.KeyProducer;
import com.beacon.kafkacoreproducer.Producer.RebalancingProducer;
import com.beacon.kafkacoreproducer.entity.Images;
import com.beacon.kafkacoreproducer.service.ImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class KafkaCoreProducerApplication  implements CommandLineRunner {
	private final KafkaProducer kafkaProducer;
	private final KeyProducer keyProducer;
	private final EmployeeJsonProducer employeeJsonProducer;
	private final RebalancingProducer rebalancingProducer;
	private final ImageService imageService;
	private final ImagesProducer imagesProducer;
	private final Images2Producer imagesProducer2;
	private final InvoiceProducer invoiceProducer;




	public KafkaCoreProducerApplication(KafkaProducer kafkaProducer, KeyProducer keyProducer, EmployeeJsonProducer employeeJsonProducer, RebalancingProducer rebalancingProducer, ImageService imageService, ImagesProducer imagesProducer, Images2Producer imagesProducer2, InvoiceProducer invoiceProducer) {
		this.kafkaProducer = kafkaProducer;
		this.keyProducer = keyProducer;
		this.employeeJsonProducer = employeeJsonProducer;
		this.rebalancingProducer = rebalancingProducer;
		this.imageService = imageService;
		this.imagesProducer = imagesProducer;
		this.imagesProducer2 = imagesProducer2;
		this.invoiceProducer = invoiceProducer;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws JsonProcessingException {
//		for(int i =0; i<10; i++) {
//			final var invoice = invoiceProducer.generateInvoice();
//			log.info("sending invoice {} ", invoice);
//			if (i > 5) {
//				invoice.setAmount(0);
//			}
//			invoiceProducer.sendMessage(invoice);
//
//		}
		Images image1 = imageService.generateImage("jpeg");
		Images image2 = imageService.generateImage("jpg");
		Images image3 = imageService.generateImage("png");
		Images image4 = imageService.generateImage("svg");
		Images image5 = imageService.generateImage("gif");
		Images image6 = imageService.generateImage("png");
		Images image7 = imageService.generateImage("svg");
		Images image8 = imageService.generateImage("svg");

		imagesProducer2.sendMessage(image1, 0);
		imagesProducer2.sendMessage(image2, 0);
		imagesProducer2.sendMessage(image8, 1);
		imagesProducer2.sendMessage(image3, 0);
		imagesProducer2.sendMessage(image4, 1);
		imagesProducer2.sendMessage(image5, 1);
		imagesProducer2.sendMessage(image6, 1);
		imagesProducer2.sendMessage(image7, 1);

//		for (int i =0 ; i<=6 ; i++) {
//////				rebalancingProducer.sendMessage();
////			Employee employee = Employee.builder().employeeId(String.valueOf(i)).name("koskei "+ i).birthDate(LocalDate.now()).build();
////			log.info(" sendgin {} ", employee);
////			employeeJsonProducer.send(employee);
//
//		}
	}
}
