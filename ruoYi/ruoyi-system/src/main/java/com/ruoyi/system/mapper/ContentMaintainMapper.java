package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.ContentMaintain;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface ContentMaintainMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param contentMaintain 预算信息
     * @return 岗位数据集合
     */
    public List<ContentMaintain> selectContentMaintainList(ContentMaintain contentMaintain);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<ContentMaintain> selectContentMaintainAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public ContentMaintain selectContentMaintainById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteContentMaintainByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param contentMaintain 岗位信息
     * @return 结果
     */
    public int updateContentMaintain(ContentMaintain contentMaintain);

    /**
     * 新增岗位信息
     * 
     * @param contentMaintain 岗位信息
     * @return 结果
     */
    public int insertContentMaintain(ContentMaintain contentMaintain);

}
