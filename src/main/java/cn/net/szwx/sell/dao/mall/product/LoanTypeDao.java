package cn.net.szwx.sell.dao.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanType;
import cn.net.szwx.sell.entity.mall.product.LoanTypeSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanTypeDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanType entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanType entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanType> list(LoanTypeSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanType getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    List<LoanType> findRecursive(LoanTypeSO so);
}
