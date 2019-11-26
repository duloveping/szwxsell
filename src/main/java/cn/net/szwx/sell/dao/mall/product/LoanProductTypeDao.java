package cn.net.szwx.sell.dao.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanProductType;
import cn.net.szwx.sell.entity.mall.product.LoanProductTypeSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanProductTypeDao {
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
