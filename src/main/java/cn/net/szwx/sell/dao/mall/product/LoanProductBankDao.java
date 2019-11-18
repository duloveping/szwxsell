package cn.net.szwx.sell.dao.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanProductBank;
import cn.net.szwx.sell.entity.mall.product.LoanProductBankSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanProductBankDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanProductBank entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanProductBank entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanProductBank> list(LoanProductBankSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanProductBank getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}
