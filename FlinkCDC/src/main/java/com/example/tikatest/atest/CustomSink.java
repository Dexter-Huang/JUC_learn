package com.example.tikatest.atest;

import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class CustomSink extends RichSinkFunction<String> {

    @Override
    public void invoke(String value, Context context) throws Exception {
        System.out.println(">>>>CustomSink: " + value);
    }

    @Override
    public void close() throws Exception {
        System.out.println(">>>>CustomSink: close");
    }

    @Override
    public void open(org.apache.flink.configuration.Configuration parameters) throws Exception {
        System.out.println(">>>>CustomSink: open");
    }
}
