package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanProductDao;
import cn.net.szwx.sell.entity.mall.product.LoanProduct;
import cn.net.szwx.sell.entity.mall.product.LoanProductSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanProductServiceImpl implements LoanProductService {
    @Autowired
    private LoanProductDao loanProductDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanProduct entity) {
        entity.preInsert();
        return loanProductDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanProduct entity) {
        entity.preUpdate();
        return loanProductDao.update(entity);
    }

    @Override
    public List<LoanProduct> list(LoanProductSO so) {
        return loanProductDao.list(so);
    }

    @Override
    public PageInfo<LoanProduct> findPage(LoanProductSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanProduct> pageInfo = new PageInfo(loanProductDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanProduct getById(Long id) {
        return loanProductDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanProductDao.deleteById(id);
    }
}
