package org.zigzzzag.parse;

import org.junit.Assert;
import org.junit.Test;
import org.zigzzzag.service.OneCParser;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ByteArray1CParseTest {

    private static final String DATA_STR = "1CClientBankExchange\n"
                                           + "ВерсияФормата=1.01\n"
                                           + "Кодировка=Windows\n"
                                           + "Отправитель=SAP ERP\n"
                                           + "Получатель=Клиент-Банк\n"
                                           + "ДатаСоздания=test\n"
                                           + "ВремяСоздания=00:00:00\n"
                                           + "ДатаНачала=test\n"
                                           + "ДатаКонца=test\n"
                                           + "РасчСчет=test\n"
                                           + "Документ=Платежное поручение\n"
                                           + "КонецДокумента\n"
                                           + "КонецФайла";

    private static final Map<String, String> DATA_MAP = Stream.of(
            new String[]{"1CClientBankExchange", ""},
            new String[]{"ВерсияФормата", "1.01"},
            new String[]{"Кодировка", "Windows"},
            new String[]{"Отправитель", "SAP ERP"},
            new String[]{"Получатель", "Клиент-Банк"},
            new String[]{"ДатаСоздания", "test"},
            new String[]{"ВремяСоздания", "00:00:00"},
            new String[]{"ДатаНачала", "test"},
            new String[]{"ДатаКонца", "test"},
            new String[]{"РасчСчет", "test"},
            new String[]{"Документ", "Платежное поручение"},
            new String[]{"КонецДокумента", ""},
            new String[]{"КонецФайла", ""}
    ).collect(Collectors.toMap(s -> s[0], s -> s[1],
                               (u, v) -> {throw new IllegalStateException(String.format("Duplicate key %s", u));},
                               LinkedHashMap::new
    ));

    private OneCParser oneCParser = new OneCParser();

    @Test
    public void parseTest() {
        Assert.assertEquals(DATA_MAP, oneCParser.toMap(DATA_STR));
        Assert.assertEquals(DATA_STR, oneCParser.fromMap(DATA_MAP));
    }
}
