package com.crusadehelper.web.forms;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.Valid;

@Data
@Valid
public class CrusadeForm {
    @NonNull
    private String player;
    @NonNull
    private String faction;
}
