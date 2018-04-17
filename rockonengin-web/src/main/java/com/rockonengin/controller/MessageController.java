package com.rockonengin.controller;

import com.rockonengin.model.protocol.request.AddMessageRequest;
import com.rockonengin.model.protocol.response.AddMessageResponse;
import com.rockonengin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangfan on 2018/3/18.
 */
@RestController
@RequestMapping("/rockonenginService/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("")
    public AddMessageResponse addMessage(@RequestBody AddMessageRequest request){

        AddMessageResponse response = new AddMessageResponse();



        return response;

    }


}
