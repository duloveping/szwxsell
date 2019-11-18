package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.entity.mall.product.LoanBank;
import cn.net.szwx.sell.entity.mall.product.LoanBankSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LoanBankService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(LoanBank entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(LoanBank entity);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<LoanBank> list(LoanBankSO so);

    PageInfo<LoanBank> findPage(LoanBankSO so);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    LoanBank getById(Long id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}
