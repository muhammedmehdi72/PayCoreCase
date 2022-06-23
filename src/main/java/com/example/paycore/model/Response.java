package com.example.paycore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 5677492213476830297L;

    private String message = "Success";
    private boolean success = true;
    private List<T> data;
}
