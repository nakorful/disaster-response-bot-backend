package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfillmentMessageText {

    private List<String> text = new ArrayList<>(5);
}
