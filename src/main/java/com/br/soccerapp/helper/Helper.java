package com.br.soccerapp.helper;

import com.br.soccerapp.exception.ObjectNullException;

import java.util.Optional;

public class Helper {

    public void verifyIsNull(Optional<?> method){
        if(method.isEmpty()) throw new ObjectNullException("");
    }
}
