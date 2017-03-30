package org.tutorial.kafka;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;

public class ProducerTest {

	final static Logger logger = LoggerFactory.getLogger(ProducerTest.class);

	@Test
	public void test() throws IOException {
		logger.debug("Test sending hello world message on Kafka.");

		KafkaProducer<String, String> producer;
		try (InputStream props = Resources.getResource("producer.props")
				.openStream()) {
			Properties properties = new Properties();
			properties.load(props);
			producer = new KafkaProducer<>(properties);
		}

		try {
			producer.send(new ProducerRecord<String, String>("test",
					"hello world from unit test."));
		}

		finally {
			producer.close();
		}

		fail("Not yet implemented");

	}
}
