package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanLabel;
import cn.net.szwx.sell.entity.mall.product.LoanLabelSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LoanLabelService {
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

    PageInfo<LoanLabel> findPage(LoanLabelSO so);

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
