package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.ContentMaintain;
import com.ruoyi.system.mapper.ContentMaintainMapper;
import com.ruoyi.system.service.IContentMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class ContentMaintainServiceImpl implements IContentMaintainService
{
    @Autowired
    private ContentMaintainMapper contentMaintainMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param contentMaintain 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<ContentMaintain> selectContentMaintainList(ContentMaintain contentMaintain)
    {
        return contentMaintainMapper.selectContentMaintainList(contentMaintain);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<ContentMaintain> selectContentMaintainAll()
    {
        return contentMaintainMapper.selectContentMaintainAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public ContentMaintain selectContentMaintainById(Long id)
    {
        return contentMaintainMapper.selectContentMaintainById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteContentMaintainByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            ContentMaintain contentMaintain = selectContentMaintainById(id);
        }
        return contentMaintainMapper.deleteContentMaintainByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param contentMaintain 岗位信息
     * @return 结果
     */
    @Override
    public int insertContentMaintain(ContentMaintain contentMaintain)
    {
        return contentMaintainMapper.insertContentMaintain(contentMaintain);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param contentMaintain 岗位信息
     * @return 结果
     */
    @Override
    public int updateContentMaintain(ContentMaintain contentMaintain)
    {
        return contentMaintainMapper.updateContentMaintain(contentMaintain);
    }


}
