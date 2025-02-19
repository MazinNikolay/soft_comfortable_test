package com.softcomfortable.com.service.impl;

import com.softcomfortable.com.service.SortService;
import com.softcomfortable.com.utils.XlsxReader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PriorityQueue;

@Service
public class SortServiceImpl implements SortService {
    @Override
    public Integer sortAndGetNMaxElement(String filePath, Integer n) {
        List<Integer> numbers = XlsxReader.readFromXlsxFile(filePath);
        PriorityQueue<Integer> maxNumbers = new PriorityQueue<>(n);
        numbers.forEach(e -> {
            maxNumbers.offer(e);
            if (maxNumbers.size() > n) {
                maxNumbers.poll();
            }
        });
        return maxNumbers.peek();
    }
}
