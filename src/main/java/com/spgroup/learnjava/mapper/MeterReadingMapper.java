package com.spgroup.learnjava.mapper;

import com.spgroup.learnjava.model.MeterReading;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MeterReadingMapper {
    @Insert("INSERT INTO meter_readings(meter_id, reading, timestamp) VALUES(#{meterId}, #{reading}, #{timestamp})")
    void insert(MeterReading meterReading);

    @Select("SELECT SUM(reading) FROM meter_readings WHERE meter_id = #{meterId}")
    Double getReadingSum(String meterId);
}
