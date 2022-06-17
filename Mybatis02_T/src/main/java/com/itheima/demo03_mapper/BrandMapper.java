package com.itheima.demo03_mapper;

import com.itheima.demo02_pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> sAll();

    Brand sOne(int id);
    List<Brand> selectbyCoon(@Param("brandName") String brandName, @Param("companyName") String companyName);


    int insert(Brand b);
}
