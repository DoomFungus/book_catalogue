package edu.kpi.book_reader.book_catalogue.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "review-service")
@RequestMapping("/review")
public interface ReviewClient {
    @GetMapping("/avg")
    Double findAverageRatingForBook(@RequestParam("book_id") Integer bookId);
}
