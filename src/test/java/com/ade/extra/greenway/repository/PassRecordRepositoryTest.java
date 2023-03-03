package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.PassRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class PassRecordRepositoryTest {

    @Autowired
    PassRecordRepository passRecordRepository;

    @Test
    void findByCreateTimeBetween() {
    }

    @Test
    void findAll() {
        System.out.println(passRecordRepository.findAll());
    }

    @Test
    void createSomethingData() {
        final List<PassRecord> collect = Stream.generate(() -> {
            PassRecord passRecord = new PassRecord();
            passRecord.setCarNo("京A" + (new Random().nextInt(89999) + 10000));
            passRecord.setCreateTime(LocalDateTime.now().minusDays(new Random().nextInt(30)));
            return passRecord;
        }).limit(20).collect(Collectors.toList());

        passRecordRepository.saveAll(collect);
    }
}