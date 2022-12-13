package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class OutputContext {

    private String name;

    private long lifespanCount;

    private Map<String, Object> parameters = new HashMap<>(5);
}
