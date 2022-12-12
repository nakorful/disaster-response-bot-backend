package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class FulfillmentMessageText {

    private List<String> text = new ArrayList<>(5);
}
