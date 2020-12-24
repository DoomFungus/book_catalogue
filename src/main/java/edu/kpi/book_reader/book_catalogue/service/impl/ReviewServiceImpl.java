package edu.kpi.book_reader.book_catalogue.service.impl;

import edu.kpi.book_reader.book_catalogue.client.ReviewClient;
import edu.kpi.book_reader.book_catalogue.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewClient reviewClient;

    @Autowired
    public ReviewServiceImpl(ReviewClient reviewClient) {
        this.reviewClient = reviewClient;
    }

    @Override
    public Double findAverageRatingForBook(Integer bookId) {
        return reviewClient.findAverageRatingForBook(bookId);
    }
}
