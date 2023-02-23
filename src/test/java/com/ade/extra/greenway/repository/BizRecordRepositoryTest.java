package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.BizRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class BizRecordRepositoryTest {

    @Autowired BizRecordRepository bizRecordRepository;

    @Test
    void findByCreateTimeBetween() {
    }

    @Test
    void findAll() {
        System.out.println(bizRecordRepository.findAll());
    }

    @Test
    void createSomethingData() {
        final List<BizRecord> collect = Stream.generate(() -> {
            BizRecord bizRecord = new BizRecord();
            bizRecord.setCarNo("京A" + (new Random().nextInt(89999) + 10000));
            bizRecord.setCreateTime(LocalDateTime.now().minusDays(new Random().nextInt(30)));
            return bizRecord;
        }).limit(20).collect(Collectors.toList());

        bizRecordRepository.saveAll(collect);
    }
}