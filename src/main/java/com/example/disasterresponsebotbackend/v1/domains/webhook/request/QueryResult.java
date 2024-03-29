package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResult {

    private String queryText;

    private Map<String, Object> parameters = new HashMap<>(5);

    private boolean allRequiredParamsPresent;

    private String fulfillmentText;

    private List<FulfillmentMessage> fulfillmentMessages = new ArrayList<>(5);

    private List<OutputContext> outputContexts = new ArrayList<>(5);

    private Intent intent;

    private long intentDetectionConfidence;

    private Object diagnosticInfo;

    private String languageCode = "en";
}
