package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanProductTypeDao;
import cn.net.szwx.sell.entity.mall.product.LoanProductType;
import cn.net.szwx.sell.entity.mall.product.LoanProductTypeSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanProductTypeServiceImpl implements LoanProductTypeService {
    @Autowired
    private LoanProductTypeDao loanProductTypeDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanProductType entity) {
        entity.preInsert();
        return loanProductTypeDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanProductType entity) {
        entity.preUpdate();
        return loanProductTypeDao.update(entity);
    }

    @Override
    public List<LoanProductType> list(LoanProductTypeSO so) {
        return loanProductTypeDao.list(so);
    }

    @Override
    public PageInfo<LoanProductType> findPage(LoanProductTypeSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanProductType> pageInfo = new PageInfo(loanProductTypeDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanProductType getById(Long id) {
        return loanProductTypeDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanProductTypeDao.deleteById(id);
    }
}
