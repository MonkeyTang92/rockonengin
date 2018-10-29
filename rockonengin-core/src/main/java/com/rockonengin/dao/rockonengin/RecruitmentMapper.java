package com.rockonengin.dao.rockonengin;


import com.rockonengin.model.entity.Recruitment;

public interface RecruitmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    Recruitment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);
}