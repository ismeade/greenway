package com.ade.extra.greenway.mapstruct;


import com.ade.extra.greenway.controller.vo.PassRecordVo;
import com.ade.extra.greenway.repository.entity.PassRecord;
import com.ade.extra.greenway.service.dto.PassRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 排序vo dto domain转化mapper
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassRecordMapper {

    PassRecordMapper INSTANCE = Mappers.getMapper(PassRecordMapper.class);

    PassRecordDto toDto(PassRecord passRecord);

    List<PassRecordDto> toDto(List<PassRecord> passRecordList);

    @Mapping(source = "createTime",
            target = "createTime",
            dateFormat = "yyyy-MM-dd HH:mm:ss")
    PassRecordVo toVo(PassRecordDto passRecordDto);

//    @Mapping(source = "createTime",
//            target = "createTime",
//            dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<PassRecordVo> toVo(List<PassRecordDto> passRecordDtoList);

}
