package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanProduct;
import cn.net.szwx.sell.entity.mall.product.LoanProductSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LoanProductService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanProduct entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanProduct entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanProduct> list(LoanProductSO so);

    PageInfo<LoanProduct> findPage(LoanProductSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanProduct getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}
