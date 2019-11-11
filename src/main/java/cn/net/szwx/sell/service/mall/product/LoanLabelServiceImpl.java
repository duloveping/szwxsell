package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanLabelDao;
import cn.net.szwx.sell.entity.mall.product.LoanLabel;
import cn.net.szwx.sell.entity.mall.product.LoanLabelSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanLabelServiceImpl implements LoanLabelService {
    @Autowired
    private LoanLabelDao loanLabelDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanLabel entity) {
        entity.preInsert();
        return loanLabelDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanLabel entity) {
        entity.preUpdate();
        return loanLabelDao.update(entity);
    }

    @Override
    public List<LoanLabel> list(LoanLabelSO so) {
        return loanLabelDao.list(so);
    }

    @Override
    public PageInfo<LoanLabel> findPage(LoanLabelSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanLabel> pageInfo = new PageInfo(loanLabelDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanLabel getById(Long id) {
        return loanLabelDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanLabelDao.deleteById(id);
    }
}
