package com.example.tikatest;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class TikaTestApplicationTests {

    @Autowired
    private Tika tika;

    @Test
    void contextLoads() throws TikaException, IOException {
        Path path = Paths.get("D:","1.txt");
        File file = path.toFile();
        System.out.println(file.exists());
        System.out.println(tika.parseToString(file));
    }

    @Test
    void test() throws TikaException, IOException, SAXException {
        File file = new File("D:\\Users\\27225\\Desktop\\简历.pdf");

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream fileInputStream = new FileInputStream(file);
        ParseContext parseContext = new ParseContext();

        //提取图像信息
        //JpegParser JpegParser = new JpegParser();
        //提取PDF
        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(fileInputStream,handler,metadata,parseContext);

        System.out.println(handler.toString());

    }

}
