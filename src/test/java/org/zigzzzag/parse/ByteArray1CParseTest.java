package org.zigzzzag.parse;

import org.junit.Assert;
import org.junit.Test;
import org.zigzzzag.service.OneCParser;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ByteArray1CParseTest {


    private static final String DATA = "1CClientBankExchange\n"
                                       + "ВерсияФормата=1.01\n"
                                       + "Кодировка=Windows\n"
                                       + "Отправитель=SAP ERP\n"
                                       + "Получатель=Клиент-Банк\n"
                                       + "ДатаСоздания=test\n"
                                       + "ВремяСоздания=00:00:00\n"
                                       + "ДатаНачала=test\n"
                                       + "ДатаКонца=test\n"
                                       + "РасчСчет=test\n"
                                       + "Документ=Платежное поручение";

    private OneCParser oneCParser = new OneCParser();

    @Test
    public void bytesToMapTest() {

        Map<String, String> expected = Stream.of(
                new Object[]{"1CClientBankExchange", ""},
                new Object[]{"ВерсияФормата", "1.01"},
                new Object[]{"Кодировка", "Windows"},
                new Object[]{"Отправитель", "SAP ERP"},
                new Object[]{"Получатель", "Клиент-Банк"},
                new Object[]{"ДатаСоздания", "test"},
                new Object[]{"ВремяСоздания", "00:00:00"},
                new Object[]{"ДатаНачала", "test"},
                new Object[]{"ДатаКонца", "test"},
                new Object[]{"РасчСчет", "test"},
                new Object[]{"Документ", "Платежное поручение"}
        ).collect(Collectors.toMap(
                s -> (String) s[0],
                s -> (String) s[1],
                (u, v) -> {throw new IllegalStateException(String.format("Duplicate key %s", u));},
                LinkedHashMap::new
        ));

        Assert.assertEquals(expected, oneCParser.toMap(DATA));
    }

    @Test
    public void mapToBytesTest() {

        Map<String, String> map = Stream.of(
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
                new String[]{"Документ", "Платежное поручение"}
        ).collect(Collectors.toMap(s -> s[0], s -> s[1],
                                   (u, v) -> {throw new IllegalStateException(String.format("Duplicate key %s", u));},
                                   LinkedHashMap::new
        ));

        Assert.assertEquals(DATA, oneCParser.fromMap(map));
    }
}
