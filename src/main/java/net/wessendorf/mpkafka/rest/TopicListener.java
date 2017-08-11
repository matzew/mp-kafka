package net.wessendorf.mpkafka.rest;

import net.wessendorf.kafka.cdi.annotation.Consumer;
import net.wessendorf.kafka.cdi.annotation.KafkaConfig;

import java.util.logging.Logger;

/**
 * Created by matzew on 8/11/17.
 */
@KafkaConfig(bootstrapServers = "#{KAFKA_HOST}:#{KAFKA_PORT}")
public class TopicListener {

    Logger logger = Logger.getLogger(TopicListener.class.getName());

    @Consumer(topic = "demo_topic", groupId = "testGroup1")
    public void onMessage(final String payload) {
        logger.warning("We got from Kafka: " + payload);
    }

}
