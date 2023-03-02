package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.BizPassRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class BizPassRecordRepositoryTest {

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
        final List<BizPassRecord> collect = Stream.generate(() -> {
            BizPassRecord bizPassRecord = new BizPassRecord();
            bizPassRecord.setCarNo("京A" + (new Random().nextInt(89999) + 10000));
            bizPassRecord.setCreateTime(LocalDateTime.now().minusDays(new Random().nextInt(30)));
            return bizPassRecord;
        }).limit(20).collect(Collectors.toList());

        bizRecordRepository.saveAll(collect);
    }
}