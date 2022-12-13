package com.example.disasterresponsebotbackend.v1.domains.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FulfillmentMessageText {

    private List<String> text;
}
