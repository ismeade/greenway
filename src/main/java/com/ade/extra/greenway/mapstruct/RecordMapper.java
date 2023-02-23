package com.ade.extra.greenway.mapstruct;


import com.ade.extra.greenway.controller.vo.RecordVo;
import com.ade.extra.greenway.repository.entity.BizRecord;
import com.ade.extra.greenway.service.dto.RecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 排序vo dto domain转化mapper
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecordMapper {

    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);

    RecordDto toDto(BizRecord bizRecord);

    List<RecordDto> toDto(List<BizRecord> bizRecordList);

    @Mapping(source = "createTime",
            target = "createTime",
            dateFormat = "yyyy-MM-dd HH:mm:ss")
    RecordVo toVo(RecordDto recordDto);

//    @Mapping(source = "createTime",
//            target = "createTime",
//            dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<RecordVo> toVo(List<RecordDto> recordDtoList);

}
