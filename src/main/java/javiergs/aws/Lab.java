public class Lab {
  public static void main(String[] args) {
    String endpoint = "a40203d8x0q5g-ats.iot.us-west-2.amazonaws.com";
    String topic = "5100/checkin";
    String cert = "device.pem.crt";
    String key  = "private.pem.key";
    String ca   = "AmazonRootCA1.pem";
    String clientId = "student-" + System.currentTimeMillis();
    String payload = "{\"id\":\"student@calpoly.edu\",\"name\":\"Student Name\"}";

    AwsIotMqtt5ClientBuilder builder =
        AwsIotMqtt5ClientBuilder.newDirectMqttBuilderWithMtlsFromPath(
            endpoint, cert, key);
    builder.withCertificateAuthorityFromPath(null, ca);
    ConnectPacket.ConnectPacketBuilder connect =
        new ConnectPacket.ConnectPacketBuilder()
            .withClientId(clientId);
    builder.withConnectProperties(connect);
    Mqtt5Client client = builder.build();
    client.start();
    PublishPacket message =
        new PublishPacket.PublishPacketBuilder(
            topic,
            QOS.AT_LEAST_ONCE,
            payload.getBytes()
        ).build();
    client.publish(message).get();
    client.stop();
  }
}
