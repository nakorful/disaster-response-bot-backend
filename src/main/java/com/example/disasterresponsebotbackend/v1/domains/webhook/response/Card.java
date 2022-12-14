package com.example.disasterresponsebotbackend.v1.domains.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    private String title;

    private String subtitle;

    private String imageUri;

    private List<Button> buttons;
}
