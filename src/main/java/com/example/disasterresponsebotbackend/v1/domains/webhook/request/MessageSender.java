package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageSender {

    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("language_code")
    private String languageCode;

    @JsonProperty("last_name")
    private String lastName;
}
