package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanProductType;
import cn.net.szwx.sell.entity.mall.product.LoanProductTypeSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LoanProductTypeService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanProductType entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanProductType entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanProductType> list(LoanProductTypeSO so);

    PageInfo<LoanProductType> findPage(LoanProductTypeSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanProductType getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    int deleteByProductId(Long productId);

    int deleteByTypeIdId(Long typeId);
}
