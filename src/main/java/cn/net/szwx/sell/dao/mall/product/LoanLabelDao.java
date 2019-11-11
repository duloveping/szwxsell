package cn.net.szwx.sell.dao.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanLabel;
import cn.net.szwx.sell.entity.mall.product.LoanLabelSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanLabelDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanLabel entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanLabel entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanLabel> list(LoanLabelSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanLabel getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}
