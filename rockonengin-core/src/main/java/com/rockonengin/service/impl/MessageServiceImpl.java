package com.rockonengin.service.impl;

/**
 * Created by tangfan on 2018/2/13.
 */

import com.rockonengin.dao.rockonengin.MessageMapper;
import com.rockonengin.model.entity.Message;
import com.rockonengin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public boolean insert(Message message) {
        return messageMapper.insert(message) == 1;
    }

    public List<Message> getMessageList() {

        return null;
    }
}
