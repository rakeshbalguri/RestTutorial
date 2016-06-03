package com.rakesh.database;

import com.rakesh.model.Message;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by osboxes on 03/06/16.
 */
public class DatabaseClass {

    private static  Map<Long,Message> messages = new LinkedHashMap<>();

    public static Map<Long,Message> getMessages()
    {
        return messages;
    }
}
