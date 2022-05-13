package com.tigran.listCars.scrapper;

import antlr.StringUtils;
import com.tigran.listCars.dto.CarDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarScrapper {
    private static final int LIMIT_PRICE = 5000;
    private static final String URL = "https://www.list.am/category/23";


    public List<CarDto> getAllCars() throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements allRows = document.select(".dl>.gl>a");

        List<CarDto> collect = allRows.stream()
                .map(c -> convert(c))
                .filter(c -> c.getPrice() > LIMIT_PRICE)
                .collect(Collectors.toList());

        return collect;


    }

    private CarDto convert(Element curr) {
        CarDto dto = new CarDto();

        String href = curr.attr("href");
        dto.setLink(href);

        String priceText = curr.select(".p").text();
        priceText = priceText.replaceAll("\\$", "");
        priceText = priceText.replaceAll(",", "");
        priceText = priceText.replaceAll("֏", "");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(priceText);
        if (matcher.find()) {
            String group = matcher.group();
            double price = Double.parseDouble(group);
            dto.setPrice(price);
        }
        String brandText = curr.select(".l").text();
        Pattern pattern1 = Pattern.compile("[a-zA-Z]+\\s?[a-zA-Z].");
        Matcher matcher1 = pattern1.matcher(brandText);
        if (matcher1.find()) {
            String brand = matcher1.group();
            dto.setBrand(brand);
        }

        String yearText = curr.select(".at").text();
        Pattern pattern2 = Pattern.compile("\\d{4}");
        Matcher matcher2 = pattern2.matcher(yearText);
        if (matcher2.find()) {
            String group = matcher2.group();
            int year = Integer.parseInt(group);
            dto.setYear(year);

        }
        return dto;
    }
}

