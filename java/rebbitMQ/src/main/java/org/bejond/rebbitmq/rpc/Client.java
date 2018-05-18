package org.bejond.rebbitmq.rpc;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class Client {

	private Connection connection;

	private Channel channel;

	private String requestQueueName = "rpc_queue";

	private String replyQueueName;

	public Client() throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		connection = factory.newConnection();
		channel = connection.createChannel();

		replyQueueName = channel.queueDeclare().getQueue();
		System.out.println("replyQueueName is: " + replyQueueName);
	}

	public String call(String message) throws IOException, InterruptedException {

		final String correlationId = UUID.randomUUID().toString();
		AMQP.BasicProperties properties = new AMQP.BasicProperties
						.Builder()
						.correlationId(correlationId)
						.replyTo(replyQueueName)
						.build();

		channel.basicPublish("", requestQueueName, properties, message.getBytes("UTF-8"));

		final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

		channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

				if ( properties.getCorrelationId().equals(correlationId) )
				{
					response.offer(new String(body, "UTF-8"));
				}
			}
		});

		return response.take();
	}

	public void close() throws IOException {

		connection.close();
	}

	public static void main(String[] args) {

		Client client = null;
		String response = null;

		try
		{
			client = new Client();
			System.out.println(" [x] Requesting fib(30)");
			response = client.call("30");
			System.out.println(" [.] Got '" + response + "'");

		}
		catch ( IOException | TimeoutException | InterruptedException e )
		{
			e.printStackTrace();
		} finally
		{
			if ( client != null )
			{
				try
				{
					client.close();
				}
				catch ( IOException e )
				{
				}
			}
		}
	}

}
