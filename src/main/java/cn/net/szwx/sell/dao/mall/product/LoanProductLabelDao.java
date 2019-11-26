package cn.net.szwx.sell.dao.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanProductLabel;
import cn.net.szwx.sell.entity.mall.product.LoanProductLabelSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanProductLabelDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanProductLabel entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanProductLabel entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanProductLabel> list(LoanProductLabelSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanProductLabel getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    int deleteByProductId(Long productId);

    int deleteByLabelId(Long labelId);
}
