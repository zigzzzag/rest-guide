package org.zigzzzag.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CommonParser {

    Map<String, String> toMap(String data);

    String fromMap(Map<String, String> data);

}
