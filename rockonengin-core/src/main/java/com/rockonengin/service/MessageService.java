package com.rockonengin.service;


import com.rockonengin.model.entity.Message;

import java.util.List;

/**
 * Created by tangfan on 2018/2/13.
 */
public interface MessageService {

    boolean insert(Message message);

    List<Message> getMessageList();
}
