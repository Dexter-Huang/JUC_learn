package com.example.tikatest.atest;

import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class Example {
    public static void main(String[] args) throws Exception {
        MySqlSource<String> source = MySqlSource.<String>builder()
            .hostname("localhost")
            .port(3306)
            .databaseList("test")
            .tableList("test.user")
            .username("root")
            .password("1234")
            .deserializer(new JsonDebeziumDeserializationSchema())
            .build();

        Configuration configuration = new Configuration();
        configuration.setInteger("rest.port", 8081);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(configuration);

        env.enableCheckpointing(5000);
        DataStreamSink<String> sink = env.fromSource(source, WatermarkStrategy.noWatermarks(), "mysql-source")
            .addSink(new CustomSink());

        env.execute();

    }
}
