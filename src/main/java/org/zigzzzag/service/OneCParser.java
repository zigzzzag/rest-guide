package org.zigzzzag.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class OneCParser implements CommonParser {

    private static final String ONE_C_CLIENT_BANK_EXCHANGE = "1CClientBankExchange";

    @Override
    public Map<String, String> toMap(String data) {
        return Pattern.compile("\\s*\n\\s*")
                .splitAsStream(data)
                .map(s -> s.split("=", 2))
                .collect(Collectors.toMap(
                        a -> a[0],
                        a -> a.length > 1 ? a[1] : "",
                        (u, v) -> {throw new IllegalStateException(String.format("Duplicate key %s", u));},
                        LinkedHashMap::new
                         )
                );
    }

    @Override
    public String fromMap(Map<String, String> data) {
        return data.entrySet().stream()
                .map(entry -> {
                    if (ONE_C_CLIENT_BANK_EXCHANGE.equals(entry.getKey())) {
                        return entry.getKey();
                    } else {
                        return entry.getKey() + "=" + entry.getValue();
                    }
                })
                .collect(Collectors.joining("\n"))
                .trim();
    }
}
