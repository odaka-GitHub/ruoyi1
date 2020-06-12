package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.General;
import com.ruoyi.system.domain.Vat;
import com.ruoyi.system.mapper.GeneralMapper;
import com.ruoyi.system.mapper.VatMapper;
import com.ruoyi.system.service.IGeneralService;
import com.ruoyi.system.service.IVatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class GeneralServiceImpl implements IGeneralService
{
    @Autowired
    private GeneralMapper generalMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param general 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<General> selectGeneralList(General general)
    {
        return generalMapper.selectGeneralList(general);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<General> selectGeneralAll()
    {
        return generalMapper.selectGeneralAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public General selectGeneralById(Long id)
    {
        return generalMapper.selectGeneralById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteGeneralByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            General general = selectGeneralById(id);
        }
        return generalMapper.deleteGeneralByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param general 岗位信息
     * @return 结果
     */
    @Override
    public int insertGeneral(General general)
    {
        return generalMapper.insertGeneral(general);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param general 岗位信息
     * @return 结果
     */
    @Override
    public int updateGeneral(General general)
    {
        return generalMapper.updateGeneral(general);
    }


}
