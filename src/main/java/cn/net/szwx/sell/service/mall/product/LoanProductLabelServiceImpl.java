package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanProductLabelDao;
import cn.net.szwx.sell.entity.mall.product.LoanProductLabel;
import cn.net.szwx.sell.entity.mall.product.LoanProductLabelSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanProductLabelServiceImpl implements LoanProductLabelService {
    @Autowired
    private LoanProductLabelDao loanProductLabelDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanProductLabel entity) {
        entity.preInsert();
        return loanProductLabelDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanProductLabel entity) {
        entity.preUpdate();
        return loanProductLabelDao.update(entity);
    }

    @Override
    public List<LoanProductLabel> list(LoanProductLabelSO so) {
        return loanProductLabelDao.list(so);
    }

    @Override
    public PageInfo<LoanProductLabel> findPage(LoanProductLabelSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanProductLabel> pageInfo = new PageInfo(loanProductLabelDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanProductLabel getById(Long id) {
        return loanProductLabelDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanProductLabelDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByProductId(Long productId) {
        return loanProductLabelDao.deleteByProductId(productId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByLabelId(Long labelId) {
        return loanProductLabelDao.deleteByLabelId(labelId);
    }
}
