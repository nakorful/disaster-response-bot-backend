package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Intent {

    private String name;

    private String displayName;
}
