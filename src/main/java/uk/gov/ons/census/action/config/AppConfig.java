package uk.gov.ons.census.action.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.inbound.AmqpInboundChannelAdapter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableScheduling
@EnableTransactionManagement
public class AppConfig {
  @Value("${queueconfig.inbound-queue}")
  private String inboundQueue;

  @Value("${queueconfig.action-fulfilment-inbound-queue}")
  private String actionFulfilmentQueue;

  @Value("${queueconfig.undelivered-mail-queue}")
  private String undeliveredMailQueue;

  @Value("${queueconfig.consumers}")
  private int consumers;

  @Bean
  public MessageChannel caseCreatedInputChannel() {
    return new DirectChannel();
  }

  @Bean
  public MessageChannel actionFulfilmentInputChannel() {
    return new DirectChannel();
  }

  @Bean
  public MessageChannel undeliveredMailInputChannel() {
    return new DirectChannel();
  }

  @Bean
  public AmqpInboundChannelAdapter inbound(
      @Qualifier("container") SimpleMessageListenerContainer listenerContainer,
      @Qualifier("caseCreatedInputChannel") MessageChannel channel) {
    AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(listenerContainer);
    adapter.setOutputChannel(channel);
    return adapter;
  }

  @Bean
  public AmqpInboundChannelAdapter fulfilmentRequestInbound(
      @Qualifier("actionFulfilmentContainer")
          SimpleMessageListenerContainer actionFulfilmentContainer,
      @Qualifier("actionFulfilmentInputChannel") MessageChannel channel) {
    AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(actionFulfilmentContainer);
    adapter.setOutputChannel(channel);
    return adapter;
  }

  @Bean
  public AmqpInboundChannelAdapter undeliveredMailInbound(
      @Qualifier("undeliveredMailContainer")
          SimpleMessageListenerContainer actionFulfilmentContainer,
      @Qualifier("undeliveredMailInputChannel") MessageChannel channel) {
    AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(actionFulfilmentContainer);
    adapter.setOutputChannel(channel);
    return adapter;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(
      ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(messageConverter);
    rabbitTemplate.setChannelTransacted(true);
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
    SimpleMessageListenerContainer container =
        new SimpleMessageListenerContainer(connectionFactory);
    container.setQueueNames(inboundQueue);
    container.setConcurrentConsumers(consumers);
    return container;
  }

  @Bean
  public SimpleMessageListenerContainer actionFulfilmentContainer(
      ConnectionFactory connectionFactory) {
    SimpleMessageListenerContainer container =
        new SimpleMessageListenerContainer(connectionFactory);
    container.setQueueNames(actionFulfilmentQueue);
    container.setConcurrentConsumers(consumers);
    return container;
  }

  @Bean
  public SimpleMessageListenerContainer undeliveredMailContainer(
      ConnectionFactory connectionFactory) {
    SimpleMessageListenerContainer container =
        new SimpleMessageListenerContainer(connectionFactory);
    container.setQueueNames(undeliveredMailQueue);
    container.setConcurrentConsumers(consumers);
    return container;
  }

  @Bean
  public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
    RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
    return rabbitAdmin;
  }
}
